package manytomany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Purpose: Hibernate ManyToMany Unidirectional Mapping Example
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

    @ManyToOne( cascade = { CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinColumn( name = "instructor_id" )
    private Instructor instructor;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinColumn( name = "course_id" )
    private List<Review> reviews;

    @ManyToMany( fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn( name = "course_id" ),
            inverseJoinColumns = @JoinColumn( name = "student_id" ) )
    private List<Student> students;

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
     * @param review {@link Review} Review object
     */
    public void addReview( Review review )
    {
        if( reviews == null )
        {
            reviews = new ArrayList<>();
        }
        reviews.add( review );
    }

    /**
     * This method simplifies adding students to a Course
     *
     * @param student {@link Student} Student object
     */
    public void addStudent( Student student )
    {
        if( students == null )
        {
            students = new ArrayList<>();
        }
        students.add( student );
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents( List<Student> students )
    {
        this.students = students;
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
