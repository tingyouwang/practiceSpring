package HW4.restfulServicePractice.service;

import HW4.restfulServicePractice.model.Member;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //匯入spring測試框架[2]
@SpringBootTest //提供spring依賴注入
@Transactional //事務管理，預設回滾,如果配置了多資料來源記得指定事務管理器
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
        String expected = "[{\"id\":\"1\",\"name\":\"Billy\",\"gender\":\"male\",\"subject\":\"Math\",\"jobTitle\":\"leader\"},{\"id\":\"2\",\"name\":\"Eric\",\"gender\":\"male\",\"subject\":\"english\",\"jobTitle\":\"teacher\"},{\"id\":\"3\",\"name\":\"Jack\",\"gender\":\"male\",\"myclass\":\"301\",\"admissionYearMonth\":\"201910\"},{\"id\":\"4\",\"name\":\"Ben\",\"gender\":\"male\",\"myclass\":\"801\",\"admissionYearMonth\":\"201909\"}]";
//        String expected = "aaa";
        List<Member> memberList = memberService.getAllMember();
        System.out.println(memberList.get(0).getName());

//        assertEquals(expected,result);
    }

    @Test
    void getAllStudent() throws JsonProcessingException {
        String expected = "[{\"id\":\"3\",\"name\":\"Jack\",\"gender\":\"male\",\"myclass\":\"301\",\"admissionYearMonth\":\"201910\"},{\"id\":\"4\",\"name\":\"Ben\",\"gender\":\"male\",\"myclass\":\"801\",\"admissionYearMonth\":\"201909\"}]";
//        String result = memberService.getAllStudent();
        List<Member> memberList = memberService.getAllStudent();
        System.out.println("!!!getAllStudent()"+memberList.get(0).getName());
//        assertEquals(expected,result);
    }

    @Test
    void getAllTeacher() throws JsonProcessingException {

        String expected = "[{\"id\":\"1\",\"name\":\"Billy\",\"gender\":\"male\",\"subject\":\"Math\",\"jobTitle\":\"leader\"},{\"id\":\"2\",\"name\":\"Eric\",\"gender\":\"male\",\"subject\":\"english\",\"jobTitle\":\"teacher\"}]";
//        String result = memberService.getAllTeacher();
        List<Member> memberList = memberService.getAllTeacher();
        System.out.println("!!!"+memberList.get(0).getName());
//        assertEquals(expected,result);
    }

    @Test
    void getStudentById() throws JsonProcessingException {
        // id = 3
        String expected = "[{\"id\":\"3\",\"name\":\"Jack\",\"gender\":\"male\",\"myclass\":\"301\",\"admissionYearMonth\":\"201910\"}]";
//        String result = memberService.getStudentById("3");
//        assertEquals(expected,result);

        System.out.println("!!!"+ memberService.getStudentById("3").getName());

    }


    @Test
    void getTeacherById() throws JsonProcessingException {
        //id = 1
        String expected = "[{\"id\":\"1\",\"name\":\"Billy\",\"gender\":\"male\",\"subject\":\"Math\",\"jobTitle\":\"leader\"}]";
        String result = memberService.getTeacherById("1");

        assertEquals(expected,result);
    }
}