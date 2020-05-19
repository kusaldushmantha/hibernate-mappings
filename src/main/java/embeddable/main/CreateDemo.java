package embeddable.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import embeddable.Company;
import embeddable.ContactPerson;

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
                                                .addAnnotatedClass( Company.class )
                                                .addAnnotatedClass( ContactPerson.class )
                                                .buildSessionFactory();
        Session session = null;

        try
        {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Company company = new Company( "String name",
                    "String address", "String phone", "String contactFirstName", "String contactLastName" );
            ContactPerson contactPerson = new ContactPerson( "String firstName", "String lastName", "String phone" );
            company.setContactPerson( contactPerson );

            session.save( company );

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
