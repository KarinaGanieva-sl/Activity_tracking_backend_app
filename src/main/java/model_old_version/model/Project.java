package model_old_version.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "session_part_interval")
    private int sessionPartInterval = 10;

    @Column(name = "screenshot_interval")
    private int screenshotInterval = 10;

    @OneToMany(mappedBy="project")
    @JsonIgnore
    private Set<Work> works;

    @OneToMany(mappedBy="project")
    @JsonIgnore
    private Set<Session> sessions;

    public void setNewInfo(Project another){
        setName(another.getName());
        setDescription(another.getDescription());
        setScreenshotInterval(another.getScreenshotInterval());
        setSessionPartInterval(another.getSessionPartInterval());
    }

    @Override
    public String toString(){
        return name;
    }
}