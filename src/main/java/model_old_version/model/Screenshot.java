package model_old_version.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "screenshots")
@Data
public class Screenshot {
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

    @Column(name = "time")
    private Time time;

    @Column(name = "date")
    private Date date;

    @Column(name = "data")
    private byte[] data;

    @Override
    public String toString(){
        return "screenshot from user with id: " + id;
    }
}
