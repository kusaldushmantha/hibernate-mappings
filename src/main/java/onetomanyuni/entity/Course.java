package onetomanyuni.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Purpose: Hibernate OneToMany Unidirectional Mapping Example
 * Created By: Kusal Kankanamge
 * Created On: 14-Apr-2020
 */
@Entity
@Table( name = "course" )
public class Course
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private int id;

    @Column( name = "title" )
    private String title;

    @ManyToOne( cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinColumn( name = "instructor_id" )
    private Instructor instructor;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn( name = "course_id" )
    private List<Review> reviews;

    public Course( String title )
    {
        this.title = title;
    }

    public Course()
    {
    }

    /**
     * This method simplifies adding reviews to a Course
     *
     * @param review {@link manytomany.entity.Review} Review object
     */
    public void addReview( Review review )
    {
        if( reviews == null )
        {
            reviews = new ArrayList<>();
        }
        reviews.add( review );
    }

    public List<Review> getReviews()
    {
        return reviews;
    }

    public void setReviews( List<Review> reviews )
    {
        this.reviews = reviews;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public Instructor getInstructor()
    {
        return instructor;
    }

    public void setInstructor( Instructor instructor )
    {
        this.instructor = instructor;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                       "id=" + id +
                       ", title='" + title + '\'' +
                       ", instructor=" + instructor +
                       '}';
    }
}
