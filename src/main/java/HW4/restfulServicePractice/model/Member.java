package HW4.restfulServicePractice.model;

import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="MEMBER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="JOB")
//@DiscriminatorValue("teacher")
@DiscriminatorOptions(force = true)
@Component
public class Member {
    @Id @Column(name="ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="MYNAME")
    String name;

    @Column(name="GENDER")
    String gender;

    @Column(name = "JOB", insertable = false,updatable = false)
//    @Column(name = "JOB")
    String job;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    //    public String getAdmission_year_month() {
//        return admission_year_month;
//    }
//
//    public void setAdmission_year_month(String admission_year_month) {
//        this.admission_year_month = admission_year_month;
//    }
//
//    public String getMyclass() {
//        return myclass;
//    }
//
//    public void setMyclass(String myclass) {
//        this.myclass = myclass;
//    }
}
