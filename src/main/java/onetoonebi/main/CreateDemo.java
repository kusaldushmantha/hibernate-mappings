package onetoonebi.main;

import onetoonebi.entity.Instructor;
import onetoonebi.entity.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Purpose: Hibernate OneToOne Bidirectional Mapping Example
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
                                                .buildSessionFactory();
        Session session = null;

        try
        {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Fetching an instructor detail
            int instructorId = 2;
            InstructorDetail instructorDetail = session.get( InstructorDetail.class, instructorId );

            System.out.println( "Instructor Details " + instructorDetail + "\n" );
            System.out.println( "Associated Instructor  " + instructorDetail.getInstructor() );

            // Delete an instructor detail along with its instructor
            session.delete( instructorDetail );

            // Delete an instructor detail without deleting its associated instructor
            // In this case, link between instructor and instructorDetail should be removed
            instructorDetail.getInstructor().setInstructorDetail( null );
            session.delete( instructorDetail );

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
