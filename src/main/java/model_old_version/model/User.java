package model_old_version.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy="owner")
    @JsonIgnore
    private Set<Project> projects;

    @OneToMany(mappedBy="user")
    @JsonIgnore
    private Set<Work> works;

//    @OneToMany(mappedBy="user")
//    @JsonIgnore
//    private Set<Session> sessions;

    public void setNewInfo(User another){
        setNickname(another.getNickname());
        setEmail(another.getEmail());
        setFirstName(another.getFirstName());
        setLastName(another.getLastName());
        setPhone(another.getPhone());
    }

    @Override
    public String toString(){
        return nickname;
    }
}