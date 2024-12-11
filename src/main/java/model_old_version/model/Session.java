package model_old_version.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "sessions")
@Data
public class Session {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "date")
    private Date date;

    @Column(name = "duration")
    private int duration;

    @Column(name = "average_activity")
    private float averageActivity;

    @OneToMany(mappedBy="session")
    private List<SessionPart> sessionParts;

    @OneToMany(mappedBy="session")
    private List<Screenshot> screenshots;

    @Override
    public String toString(){
        return "session from project with id: " + project;
    }
}
