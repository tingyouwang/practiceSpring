package HW4.restfulServicePractice.service;

import HW4.restfulServicePractice.model.Member;
import HW4.restfulServicePractice.model.Student;
import HW4.restfulServicePractice.model.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //匯入spring測試框架[2]
@SpringBootTest //提供spring依賴注入
//@Transactional //事務管理，預設回滾,如果配置了多資料來源記得指定事務管理器
class MemberServiceTest {

    @Autowired MemberService memberService;

    @BeforeEach
    public void setUp(){
        System.out.println("開始~~~~~");
    }
    @AfterEach
    public void tearDown(){
        System.out.println("結束!!");
    }

    @Test
    @DisplayName("測設getAllMember")
    void getAllMember() throws JsonProcessingException {

        List<Member> memberList = memberService.getAllMember();
        for(int i=0;i<memberList.size();i++){
            System.out.println(memberList.get(i).getName());
        }
//        assertEquals(expected,result);
    }

    @Test
    void getAllStudent() throws JsonProcessingException {

        List<Member> memberList = memberService.getAllStudent();

        for(int i=0;i<memberList.size();i++){
            System.out.println(memberList.get(i).getName());
        }

//        assertEquals(expected,result);
    }

    @Test
    void getAllTeacher() throws JsonProcessingException {

        List<Member> memberList = memberService.getAllTeacher();

        for(int i=0;i<memberList.size();i++){
            System.out.println(memberList.get(i).getName());
        }
//        assertEquals(expected,result);
    }

    @Test
    void getStudentById() throws JsonProcessingException {

//        String result = memberService.getStudentById("3");
//        assertEquals(expected,result);
        try{
            System.out.println("~~"+memberService.getStudentById(3).getName());

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("此ID非學生");
        }

    }


    @Test
    void getTeacherById() throws JsonProcessingException {

        try{

            System.out.println("!!"+memberService.getTeacherById(3).getName());
        } catch (NoResultException e) {
            e.printStackTrace();
            System.out.println("此ID非老師");
        }

    }

    @Test
    void insertNewTeacher() {

        Teacher teacher = new Teacher();
        teacher.setId(7);
        teacher.setName("Judy");
        teacher.setGender("female");
        teacher.setSubject("math");
        teacher.setJobTitle("leader");
        teacher.setJob("teacher");

        memberService.insertNewTeacher(teacher);

    }

    @Test
    void insertNewStudent() {

        Student student = new Student();
        student.setId(10);
        student.setName("helen");
        student.setGender("female");
        student.setMyclass("999");
        student.setAdmissionYearMonth("202203");
        student.setJob("student");

        memberService.insertNewStudent(student);

    }

    @Test
    void insertNewMem() {

        Member mem = new Member();
        mem.setId(8);
        mem.setName("gary");
        mem.setGender("male");
        mem.setJob("teacher");

        memberService.insertNewMem(mem);

    }

    @Test
    void updateTeacherById(){
        memberService.updateTeacherByid(7,"Judy2","girl","teacher2","CS","Master");
    }

    @Test
    void updateStudentById() {
        memberService.updateStudentByid(4,"Ben2","boy","student2","888","202203");
    }

    @Test
    void deleteTeacherById() {
        memberService.deleteTeacherByid(2);
    }
}