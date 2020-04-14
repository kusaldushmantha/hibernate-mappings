package onetomanyuni.main;

import onetomanyuni.entity.Course;
import onetomanyuni.entity.Instructor;
import onetomanyuni.entity.InstructorDetail;
import onetomanyuni.entity.Review;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Purpose: Hibernate OneToMany Unidirectional Mapping Example
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
                                                .addAnnotatedClass( Review.class )
                                                .buildSessionFactory();
        Session session = null;

        try
        {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Get the course
            int courseId = 11;
            Course course = session.get( Course.class, courseId );

            if( course != null )
            {
                System.out.println( "Course : " + course + "\n" );

                Review review = new Review( "Great Course" );
                course.addReview( review );

                session.save( course );
            }

            course = session.get( Course.class, courseId );
            System.out.println( "Reviews : " + course.getReviews() );

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
