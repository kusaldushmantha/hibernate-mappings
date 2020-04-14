package onetomanybi.main;

import onetomanybi.entity.Course;
import onetomanybi.entity.Instructor;
import onetomanybi.entity.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Purpose: Hibernate OneToMany Bidirectional Mapping Example
 * Created By: Kusal Kankanamge
 * Created On: 14-Apr-2020
 */
public class CreateDemo
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration()
                                                .configure( "hibernate.cfg.xml" )
                                                .addAnnotatedClass( Instructor.class )
                                                .addAnnotatedClass( InstructorDetail.class )
                                                .addAnnotatedClass( Course.class )
                                                .buildSessionFactory();
        Session session = null;

        try
        {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Adding new instructor
            Instructor instructorOne = new Instructor( "Lisa", "Walker", "lwalker@gmail.com" );
            InstructorDetail instructorDetailOne = new InstructorDetail( "http://youtube.com/walkerlisa", "Swimming" );
            instructorOne.setInstructorDetail( instructorDetailOne );

            session.save( instructorOne );

            // Creating courses and saving courses
            int instId = 4;
            Instructor instructor = session.get( Instructor.class, instId );

            Course courseOne = new Course( "Social Media Marketing Trends" );
            Course courseTwo = new Course( "Promote Yourself : The Guide" );
            instructor.addCourse( courseOne );
            instructor.addCourse( courseTwo );

            session.save( courseOne );
            session.save( courseTwo );
            session.persist( instructor ); // If persist() is used, both courses and instructor will be saved


            // Get instructor and courses
            instructor = session.get( Instructor.class, instId );
            if( instructor != null )
            {
                System.out.println( "Instructor : " + instructor + "\n" );
                System.out.println( "Courses : " + instructor.getCourses() );
            }

            // Delete course : This will only delete the course, not the instructor due to cascading
//            Course course = session.get( Course.class, 12 );
//            if( course != null )
//            {
//                session.delete( course );
//            }

            session.getTransaction().commit();
        }
        catch( HibernateException e )
        {
            e.printStackTrace();
        }
        finally
        {
            if( session != null )
            {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
