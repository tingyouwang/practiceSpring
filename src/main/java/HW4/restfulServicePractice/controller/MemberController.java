package HW4.restfulServicePractice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import HW4.restfulServicePractice.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController

public class MemberController {

    @Autowired
    MemberService mService;

    @GetMapping(value = "/rest/all-teacher")
    public String allTeacher() throws JsonProcessingException {

        return mService.allTeacher();

    }

    @GetMapping(value = "/rest/all-student")
    public String allStudent() throws JsonProcessingException {

        return mService.allStudent();

    }

    @GetMapping(value = "/rest/student")
    public String getStudentbyid(HttpServletRequest request) throws JsonProcessingException {

        String id = request.getParameter("id");

        return mService.getStudentbyid(id);

    }
}
