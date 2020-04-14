package onetooneuni.main;

import onetooneuni.entity.Instructor;
import onetooneuni.entity.InstructorDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Purpose: Hibernate OneToOne Unidirectional Mapping Example
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

            // Creating new instructors along with their instructor details
            Instructor instructorOne = new Instructor( "Joanna", "Dommer", "joanna@gmail.com" );
            InstructorDetail instructorDetailOne = new InstructorDetail( "http://youtube.com/joanna", "Swim" );
            instructorOne.setInstructorDetail( instructorDetailOne );

            session.save( instructorOne );

            Instructor instructor = session.get( Instructor.class, 1 );
            if( instructor != null )
            {
                session.delete( instructor );
            }

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
