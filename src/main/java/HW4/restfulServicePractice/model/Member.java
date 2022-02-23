package HW4.restfulServicePractice.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="MEMBER")
@Component
public class Member {
    @Id @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    @Column(name="name")
    String name;
    @Column(name="gender")
    String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
