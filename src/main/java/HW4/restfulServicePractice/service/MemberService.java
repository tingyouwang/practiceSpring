package HW4.restfulServicePractice.service;

import HW4.restfulServicePractice.model.Teacher;
import HW4.restfulServicePractice.repository.MemberListRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import HW4.restfulServicePractice.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberListRepo mListRepo;

//    public String getAllMember() throws JsonProcessingException {
//
//        List<Member> memberList = mListRepo.getAllMember();
//
//        ObjectMapper objmapper = new ObjectMapper();
//        String memberJson = objmapper.writeValueAsString(memberList);
//
//        return memberJson;
//
//    }
    public List<Member> getAllMember() {
        return mListRepo.findAll();
    }

//    public String getAllStudent() throws JsonProcessingException {
//
//        List<Student> studentList = mListRepo.getAllStudent();
//
//        ObjectMapper objmapper = new ObjectMapper();
//        String studentJson = objmapper.writeValueAsString(studentList);
//
//        return studentJson;
//
//    }
    public List<Member> getAllStudent() {
        Member member = new Member();
        member.setJob("student");
        Example<Member> example = Example.of(member);

        return mListRepo.findAll(example);
        
    }

//    public String getAllTeacher() throws JsonProcessingException {
//
//        List<Teacher> teacherList = mListRepo.getAllTeacher();
//
//        ObjectMapper objmapper = new ObjectMapper();
//        String teacherJson = objmapper.writeValueAsString(teacherList);
//
//        return teacherJson;
//
//    }

    public List<Member> getAllTeacher() {
        Member member = new Member();
        member.setJob("teacher");
        Example<Member> example = Example.of(member);

        return mListRepo.findAll(example);

    }

    public Member getStudentById(String id) throws JsonProcessingException {

        Optional<Member> oneStudent = mListRepo.findById(Integer.valueOf(id));

//        ObjectMapper objmapper = new ObjectMapper();
//        String studentJson = objmapper.writeValueAsString(oneStudent);

        return oneStudent.get();

    }

    public String getTeacherById(String id) throws JsonProcessingException {

        List<Teacher> oneTeacher = mListRepo.getTeacherById(id);

        ObjectMapper objmapper = new ObjectMapper();
        String teacherJson = objmapper.writeValueAsString(oneTeacher);

        return teacherJson;

    }


}
