package HW4.restfulServicePractice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import HW4.restfulServicePractice.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static HW4.restfulServicePractice.model.Member.memberlist;

@Service
public class MemberService {
    List<Member> memberList = memberlist();

    public String allTeacher() throws JsonProcessingException {

        //先把老師放入新的List
        List<Member> teacherList = new ArrayList<>();
        teacherList.add(memberList.get(0));
        teacherList.add(memberList.get(1));

        //轉json
        ObjectMapper objmapper = new ObjectMapper();
        String teacherJson = objmapper.writeValueAsString(teacherList);

        return teacherJson;

    }

    public String allStudent() throws JsonProcessingException {

        //先把老師放入新的List
        List<Member> studentList = new ArrayList<>();
        studentList.add(memberList.get(2));
        studentList.add(memberList.get(3));

        //轉json
        ObjectMapper objmapper = new ObjectMapper();
        String studentJson = objmapper.writeValueAsString(studentList);

        return studentJson;

    }

    public String getStudentbyid(String id) throws JsonProcessingException {

        //先把老師放入新的List
        List<Member> studentList = new ArrayList<>();

        int id_int = Integer.parseInt(id) -1;

        studentList.add(memberList.get(id_int));

        //轉json
        ObjectMapper objmapper = new ObjectMapper();
        String studentJson = objmapper.writeValueAsString(studentList);

        return studentJson;

    }

}