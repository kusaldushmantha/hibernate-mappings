package embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactPerson
{
    @Column( name = "contact_firstname" )
    private String firstName;

    @Column( name = "contact_lastname" )
    private String lastName;

    @Column( name = "contact_phone" )
    private String phone;

    public ContactPerson( String firstName, String lastName, String phone )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public ContactPerson()
    {
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }
}