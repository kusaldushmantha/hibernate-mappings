package manytomany.main;

import manytomany.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Purpose: Hibernate ManyToMany Unidirectional Mapping Example
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
                                                .addAnnotatedClass( Student.class )
                                                .buildSessionFactory();
        Session session = null;

        try
        {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Course course = new Course( "Advanced HTML CSS Guide" );
//            session.save( course );

            // Creating the student
/*            Student studentOne = new Student( "Han", "Solo", "hans@gmail.com" );
            Student studentTwo = new Student( "Marry", "Poppins", "marry@gmail.com" );

            course.addStudent( studentOne );
            course.addStudent( studentTwo );

            session.save( studentOne );
            session.save( studentTwo );*/

            // Add courses to a specific student
/*            int studentId = 2;
            Student student = session.get( Student.class, studentId );

            System.out.println( "Student : " + student + "\n" );
            Course newCourseOne = new Course( "100 Cooking Recipes" );
            Course newCourseTwo = new Course( "Cracking The Next Coding Interview" );

            newCourseOne.addStudent( student );
            newCourseTwo.addStudent( student );

            session.save( newCourseOne );
            session.save( newCourseTwo );*/

            // Get courses for a specific student
/*            int studentGetId = 2;
            Student getStudent = session.get( Student.class, studentGetId );

            System.out.println( "Student : " + getStudent + "\n" );
            System.out.println( "Courses : " + getStudent.getCourses() );*/

            // Delete a course
            int deleteCourseId = 10;
            Course deleteCourse = session.get( Course.class, deleteCourseId );
            session.delete( deleteCourse );

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
