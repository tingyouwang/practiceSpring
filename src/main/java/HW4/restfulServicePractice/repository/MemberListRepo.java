package HW4.restfulServicePractice.repository;

import HW4.restfulServicePractice.model.Member;
import HW4.restfulServicePractice.model.Student;
import HW4.restfulServicePractice.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//public interface MemberListRepo extends JpaRepository<Member,Integer> {
////    @Query(value = " select m from Member m")
//////    @Query(value = " from Member", nativeQuery = false)
////    public List<Member> getAllMember();
//
////    @Query(value = " select s from Student s")
////    public List<Student> getAllStudent();
////
////    @Query(value = " select t from Teacher t")
////    public List<Teacher> getAllTeacher();
////
////    @Query(value = " select s from Student s where s.id= :id1 ")
////    public List<Student> getStudentById(@Param("id1") String id);
////
////    @Query(value = " select t from Teacher t where t.id= :id1 ")
////    public List<Teacher> getTeacherById(@Param("id1") String id);
//
//    public Member findByIdAndJob(Integer id, String job);
//
//}
