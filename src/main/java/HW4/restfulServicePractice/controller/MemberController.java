package HW4.restfulServicePractice.controller;

import HW4.restfulServicePractice.model.ActionResult;
import HW4.restfulServicePractice.model.Member;
import HW4.restfulServicePractice.model.Student;
import HW4.restfulServicePractice.model.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import HW4.restfulServicePractice.service.MemberService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController

public class MemberController {

    @Autowired
    MemberService mService;
    @Autowired
    ActionResult resultMsg;

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
    @GetMapping(value = "/rest/inesert/teacher")
    public String insertNewTeacher(@RequestBody Teacher teacher) {

        if(teacher.getId().equals("") || teacher.getId().equals(null)) {

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("新增老師失敗，請輸入id");

        } else {

            mService.insertNewTeacher(teacher);

            resultMsg.setVerifySuccess(true);
            resultMsg.setMessage("新增老師成功:"+teacher.getName());
            resultMsg.setId(teacher.getId());
            resultMsg.setName(teacher.getName());

        }

        return resultMsg.getMessage();

    }

    @GetMapping(value = "/rest/inesert/student")
    public String insertNewStudent(@RequestBody Student student) {

        if(student.getId().equals("") || student.getId().equals(null)) {

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("新增學生失敗，請輸入id");

        } else {

            mService.insertNewStudent(student);

            resultMsg.setVerifySuccess(true);
            resultMsg.setMessage("新增學生成功:"+student.getName());
            resultMsg.setId(student.getId());
            resultMsg.setName(student.getName());

        }

        return resultMsg.getMessage();

    }

    @GetMapping(value = "/rest/delete/teacher")
    public String deleteTeacherById(HttpServletRequest request) {

        String id = request.getParameter("id");

        if(id.equals(null) || id.equals("")){

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("刪除老師失敗，請輸入id");

        }else{

            ActionResult result = mService.deleteTeacherByid(Integer.valueOf(id));
            resultMsg.setVerifySuccess(result.getVerifySuccess());
            resultMsg.setMessage(result.getMessage());

        }

        return resultMsg.getMessage();

    }

    @GetMapping(value = "/rest/delete/student")
    public String deleteStudentById(HttpServletRequest request) {

        String id = request.getParameter("id");

        if(id.equals(null) || id.equals("")){

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("刪除學生失敗，請輸入id");

        }else{

            ActionResult result = mService.deleteStudentByid(Integer.valueOf(id));
            resultMsg.setVerifySuccess(result.getVerifySuccess());
            resultMsg.setMessage(result.getMessage());

        }

        return resultMsg.getMessage();

    }

    @GetMapping(value = "/rest/update/teacher")
    public String updateTeacherByid(@RequestBody Teacher teacher) {

        if(teacher.getId().equals(null) || teacher.getId().equals("")) {

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("更新老師失敗，請輸入id");

        }else {

            ActionResult result = mService.updateTeacherByid(teacher.getId(), teacher.getName(), teacher.getGender(), teacher.getJob(), teacher.getSubject(), teacher.getJobTitle());
            resultMsg.setVerifySuccess(result.getVerifySuccess());
            resultMsg.setMessage(result.getMessage());

        }

        return resultMsg.getMessage();

    }

    @GetMapping(value = "/rest/update/student")
    public String updateStudentByid(@RequestBody Student student) {

        if(student.getId().equals(null) || student.getId().equals("")) {

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("更新學生失敗，請輸入id");

        }else {

            ActionResult result = mService.updateStudentByid(student.getId(), student.getName(), student.getGender(), student.getJob(), student.getMyclass(), student.getAdmissionYearMonth());
            resultMsg.setVerifySuccess(result.getVerifySuccess());
            resultMsg.setMessage(result.getMessage());

        }

        return resultMsg.getMessage();

    }

}
