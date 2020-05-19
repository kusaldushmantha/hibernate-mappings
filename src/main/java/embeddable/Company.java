package embeddable;

import javax.persistence.*;

@Entity
@Table( name = "company" )
public class Company
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "company_id" )
    private int id;

    @Column( name = "company_name" )
    private String name;

    @Column( name = "company_address" )
    private String address;

    @Column( name = "company_phone" )
    private String phone;

    @Column( name = "company_firstname" )
    private String contactFirstName;

    @Column( name = "company_lastname" )
    private String contactLastName;

    @Embedded
    private ContactPerson contactPerson;

    public Company()
    {
    }

    public Company( String name, String address, String phone, String contactFirstName, String contactLastName )
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public String getContactFirstName()
    {
        return contactFirstName;
    }

    public void setContactFirstName( String contactFirstName )
    {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName()
    {
        return contactLastName;
    }

    public void setContactLastName( String contactLastName )
    {
        this.contactLastName = contactLastName;
    }

    public ContactPerson getContactPerson()
    {
        return contactPerson;
    }

    public void setContactPerson( ContactPerson contactPerson )
    {
        this.contactPerson = contactPerson;
    }
}

