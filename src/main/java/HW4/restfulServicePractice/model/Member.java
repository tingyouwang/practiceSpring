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

    @Column(name="SUBJECT")
    String subject;

    @Column(name="JOB_TITLE")
    String job_title;

//    @Column(name="ADMISSION_YEAR_MONTH")
//    String admission_year_month;
//
//    @Column(name="class")
//    String myclass;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
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
