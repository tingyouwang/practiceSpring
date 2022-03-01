package HW4.restfulServicePractice.controller;

import HW4.restfulServicePractice.model.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import HW4.restfulServicePractice.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController

public class MemberController {

    @Autowired
    MemberService mService;

    @GetMapping(value = "/rest/all-member")
    public List<Member> getallMember() throws JsonProcessingException {

        return mService.getAllMember();

    }

    @GetMapping(value = "/rest/all-teacher")
    public List<Member> allTeacher() throws JsonProcessingException {

        return mService.getAllTeacher();

    }

    @GetMapping(value = "/rest/all-student")
    public List<Member> allStudent() throws JsonProcessingException {

        return mService.getAllStudent();

    }

    @GetMapping(value = "/rest/student")
    public Member getStudentbyid(HttpServletRequest request) throws JsonProcessingException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        return mService.getStudentById(id);

    }

    @GetMapping(value = "/rest/teacher")
    public Member getTeacherbyid(HttpServletRequest request) throws JsonProcessingException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        return mService.getTeacherById(id);

    }

}
