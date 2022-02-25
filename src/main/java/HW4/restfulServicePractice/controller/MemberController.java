package HW4.restfulServicePractice.controller;

import HW4.restfulServicePractice.model.Member;
import HW4.restfulServicePractice.model.Student;
import HW4.restfulServicePractice.model.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import HW4.restfulServicePractice.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController

public class MemberController {

    @Autowired
    MemberService mService;

    @GetMapping(value = "/rest/all-member")
    public String getallMember() throws JsonProcessingException {

        return mService.getAllMember();

    }

    @GetMapping(value = "/rest/all-teacher")
    public String allTeacher() throws JsonProcessingException {

        return mService.getAllTeacher();

    }

    @GetMapping(value = "/rest/all-student")
    public String allStudent() throws JsonProcessingException {

        return mService.getAllStudent();

    }

    @GetMapping(value = "/rest/student")
    public String getStudentbyid(HttpServletRequest request) throws JsonProcessingException {

        String id = request.getParameter("id");

        return mService.getStudentById(id);

    }

    @GetMapping(value = "/rest/teacher")
    public String getTeacherbyid(HttpServletRequest request) throws JsonProcessingException {

        String id = request.getParameter("id");

        return mService.getTeacherById(id);

    }

//    @GetMapping(value = "/rest/student")
//    public String getStudentbyid(HttpServletRequest request) throws JsonProcessingException {
//
//        String id = request.getParameter("id");
//
//        return mService.getStudentbyid(id);
//
//    }

//    public static List<Member> memberlist() {
//        Teacher t1 = new Teacher();
//        Teacher t2 = new Teacher();
//        Student s1 = new Student();
//        Student s2 = new Student();
//
//        t1.setId("1");
//        t1.setName(("billy"));
//        t1.setGender("male");
//        t1.setSubject("數學");
//        t1.setJobTitle("教務主任");
//
//        t2.setId("2");
//        t2.setName(("Heidi"));
//        t2.setGender("female");
//        t2.setSubject("英文");
//        t2.setJobTitle("教師");
//
//        s1.setId("3");
//        s1.setName(("Jacky"));
//        s1.setGender("male");
//        s1.setMyclass("301");
//        s1.setAdmissionYearMonth("201910");
//
//        s2.setId("4");
//        s2.setName(("Lawrence"));
//        s2.setGender("male");
//        s2.setMyclass("801");
//        s2.setAdmissionYearMonth("201812");
//
//        List<Member> memberslist = new ArrayList<>();
//        memberslist.add(t1);
//        memberslist.add(t2);
//        memberslist.add(s1);
//        memberslist.add(s2);
//
//        return memberslist;
//
//    }
}
