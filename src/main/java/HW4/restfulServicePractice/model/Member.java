package HW4.restfulServicePractice.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    String id;
    String name;
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

    public static List<Member> memberlist() {
        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
        Student s1 = new Student();
        Student s2 = new Student();

        t1.setId("1");
        t1.setName(("billy"));
        t1.setGender("male");
        t1.setSubject("數學");
        t1.setJobTitle("教務主任");

        t2.setId("2");
        t2.setName(("Heidi"));
        t2.setGender("female");
        t2.setSubject("英文");
        t2.setJobTitle("教師");

        s1.setId("3");
        s1.setName(("Jacky"));
        s1.setGender("male");
        s1.setMyclass("301");
        s1.setAdmissionYearMonth("201910");

        s2.setId("4");
        s2.setName(("Lawrence"));
        s2.setGender("male");
        s2.setMyclass("801");
        s2.setAdmissionYearMonth("201812");

        List<Member> memberslist = new ArrayList<>();
        memberslist.add(t1);
        memberslist.add(t2);
        memberslist.add(s1);
        memberslist.add(s2);

        return memberslist;

    }
}
