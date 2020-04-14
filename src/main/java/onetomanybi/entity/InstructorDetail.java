package onetomanybi.entity;

import javax.persistence.*;

/**
 * Purpose: Hibernate OneToMany Bidirectional Mapping Example
 * Created By: Kusal Kankanamge
 * Created On: 14-Apr-2020
 */
@Entity
@Table( name = "instructor_detail" )
public class InstructorDetail
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private int id;

    @Column( name = "youtube_channel" )
    private String youtubeChannel;

    @Column( name = "hobby" )
    private String hobby;

    @OneToOne( mappedBy = "instructorDetail", cascade = CascadeType.ALL )
    private Instructor instructor;

//    Delete only the instructor detail, not along with the associated instructor
//    @OneToOne( mappedBy = "instructorDetail", cascade = { CascadeType.DETACH, CascadeType.MERGE,
//            CascadeType.PERSIST, CascadeType.REFRESH } )
//    private Instructor instructor;

    public InstructorDetail( String youtubeChannel, String hobby )
    {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public InstructorDetail()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getYoutubeChannel()
    {
        return youtubeChannel;
    }

    public void setYoutubeChannel( String youtubeChannel )
    {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby()
    {
        return hobby;
    }

    public void setHobby( String hobby )
    {
        this.hobby = hobby;
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
        return "InstructorDetail{" +
                       "id=" + id +
                       ", youtubeChannel='" + youtubeChannel + '\'' +
                       ", hobby='" + hobby + '\'' +
                       '}';
    }
}
