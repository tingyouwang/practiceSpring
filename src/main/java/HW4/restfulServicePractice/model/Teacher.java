package HW4.restfulServicePractice.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends Member {

    @Column(name="SUBJECT")
    String subject;

    @Column(name="JOB_TITLE")
    String jobTitle;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
