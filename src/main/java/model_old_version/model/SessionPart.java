package model_old_version.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "session_parts")
@Data
public class SessionPart {
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

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonIgnore
    private Session session;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "date")
    private Date date;

    @Column(name = "duration")
    private int duration;

    @Column(name = "mouse_click")
    private int mouseClick;

    @Column(name = "mouse_move")
    private int mouseMove;

    @Column(name = "key_click")
    private int keyClick;

    @Column(name = "average_activity")
    private float averageActivity;

    @Override
    public String toString(){
        return "session part from session with id: " + session;
    }
}
