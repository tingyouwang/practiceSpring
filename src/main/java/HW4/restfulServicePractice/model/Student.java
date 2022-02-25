package HW4.restfulServicePractice.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("student")
public class Student extends Member {

    @Column(name="MYCLASS")
    String myclass;

    @Column(name="ADMISSION_YEAR_MONTH")
    String admissionYearMonth;

    public String getMyclass() {
        return myclass;
    }

    public void setMyclass(String myclass) {
        this.myclass = myclass;
    }

    public String getAdmissionYearMonth() {
        return admissionYearMonth;
    }

    public void setAdmissionYearMonth(String admissionYearMonth) {
        this.admissionYearMonth = admissionYearMonth;
    }
}
