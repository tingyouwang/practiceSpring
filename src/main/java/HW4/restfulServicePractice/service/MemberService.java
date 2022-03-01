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

    public List<Member> getAllMember() {
        return mListRepo.findAll();
    }

    public List<Member> getAllStudent() {
        Member member = new Member();
        member.setJob("student");
        Example<Member> example = Example.of(member);

        return mListRepo.findAll(example);
        
    }

    public List<Member> getAllTeacher() {
        Member member = new Member();
        member.setJob("teacher");
        Example<Member> example = Example.of(member);

        return mListRepo.findAll(example);

    }

    public Member getStudentById(Integer id) throws JsonProcessingException {

//        Optional<Member> oneStudent = mListRepo.findById(Integer.valueOf(id));
        Member oneStudent = mListRepo.findByIdAndJob(id,"student");

        return oneStudent;

    }

    public Member getTeacherById(Integer id) throws JsonProcessingException {

        Member oneTeacher = mListRepo.findByIdAndJob(id,"teacher");

        return oneTeacher;

    }




}
