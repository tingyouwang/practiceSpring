package HW4.restfulServicePractice.service;

import HW4.restfulServicePractice.model.ActionResult;
import HW4.restfulServicePractice.model.Member;
import HW4.restfulServicePractice.model.Student;
import HW4.restfulServicePractice.model.Teacher;
//import HW4.restfulServicePractice.repository.MemberListRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.security.PrivateKey;
import java.util.List;


@Service
@Transactional
public class MemberService {

//    @Autowired
//    private MemberListRepo mListRepo;
    @Autowired
    ActionResult resultMsg;

//    public List<Member> getAllMember() {
//        return mListRepo.findAll();
//    }
//
//    public List<Member> getAllStudent() {
//        Member member = new Member();
//        member.setJob("student");
//        Example<Member> example = Example.of(member);
//
//        return mListRepo.findAll(example);
//
//    }

//    public List<Member> getAllTeacher() {
//        Member member = new Member();
//        member.setJob("teacher");
//        Example<Member> example = Example.of(member);
//
//        return mListRepo.findAll(example);
//
//    }

//    public Member getStudentById(Integer id) throws JsonProcessingException {
//
////        Optional<Member> oneStudent = mListRepo.findById(Integer.valueOf(id));
//        Member oneStudent = mListRepo.findByIdAndJob(id,"student");
//
//        return oneStudent;
//
//    }

//    public Member getTeacherById(Integer id) throws JsonProcessingException {
//
//        Member oneTeacher = mListRepo.findByIdAndJob(id,"teacher");
//
//        return oneTeacher;
//
//    }
    @Autowired
    @PersistenceContext
    private EntityManager em ;
    public List<Member> getAllMember(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        Root<Member> root = cq.from(Member.class);
        List<Member> memberList = em.createQuery(cq).getResultList();

        return memberList;

    }

    public List<Member> getAllStudent(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        //root 就是 tale
        Root<Member> root = query.from(Member.class);
        /* 其實跟寫sql邏輯一樣，
        *  select * from root where 加條件
        * */
        query.select(root).where(cb.equal(root.get("job"), "student"));

        List<Member> studentList = em.createQuery(query).getResultList();

        return studentList;

    }

    public List<Member> getAllTeacher(){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        Root<Member> root = query.from(Member.class);

        query.select(root).where(cb.equal(root.get("job"),"teacher"));
        List<Member> teacherList = em.createQuery(query).getResultList();

        return teacherList;

    }
    public Member getStudentById(Integer id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        Root<Member> root = query.from(Member.class);

        //利用predicate 下多條件 ，換句話說predicate 等於 where
        Predicate[] predicates = new Predicate[2];
        predicates[0] = cb.equal(root.get("job"),"student");
        predicates[1] = cb.equal(root.get("id"),id);

        query.select(root).where(predicates);

        Member member = em.createQuery(query).getSingleResult();

        return  member;

    }

    public Member getTeacherById(Integer id) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);
        Root<Member> root = query.from(Member.class);

        //利用predicate 下多條件
        Predicate[] predicates = new Predicate[2];
        predicates[0] = cb.equal(root.get("job"),"teacher");
        predicates[1] = cb.equal(root.get("id"),id);

        query.select(root).where(predicates);

        Member member = em.createQuery(query).getSingleResult();

        return  member;

    }

    public void insertNewTeacher(Teacher teacher) {

        this.em.persist(teacher);

    }

    public void insertNewStudent(Student student) {

        this.em.persist(student);

    }

    public void insertNewMem(Member member) {

        this.em.persist(member);

    }

    public ActionResult updateTeacherByid(Integer id,String newName, String newGender, String newJob, String newSubject, String newJobtitle) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Teacher> criteriaUpdate = cb.createCriteriaUpdate(Teacher.class);
        Root<Teacher> root = criteriaUpdate.from(Teacher.class);
        if(newName!=null && newName!="") {
            criteriaUpdate.set("name",newName);
        }
        if(newGender!=null && newGender!="") {
            criteriaUpdate.set("gender",newGender);
        }
        if(newJob!=null && newJob!="") {
            criteriaUpdate.set("job",newJob);
        }
        if(newSubject!=null && newSubject!="") {
            criteriaUpdate.set("subject",newSubject);
        }
        if(newJobtitle!=null && newJobtitle!="") {
            criteriaUpdate.set("jobTitle",newJobtitle);
        }

        criteriaUpdate.where(cb.equal(root.get("id"), id));

        int i = em.createQuery(criteriaUpdate).executeUpdate();

        if(i==0) {

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("更新失敗，請聯絡管理員");

        } else {

            resultMsg.setVerifySuccess(true);
            resultMsg.setMessage("更新老師"+i+"筆成功");

        }

        return resultMsg;

    }

    public ActionResult updateStudentByid(Integer id,String newName, String newGender, String newJob,String newclass,String newAdmissionYearMonth) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Student> criteriaUpdate = cb.createCriteriaUpdate(Student.class);
        Root<Student> root = criteriaUpdate.from(Student.class);

        if(newName!=null && newName!="") {
            criteriaUpdate.set("name",newName);
        }
        if(newGender!=null && newGender!="") {
            criteriaUpdate.set("gender",newGender);
        }
        if(newJob!=null && newJob!="") {
            criteriaUpdate.set("job",newJob);
        }
        if(newclass!=null && newclass!="") {
            criteriaUpdate.set("myclass",newclass);
        }
        if(newAdmissionYearMonth!=null && newAdmissionYearMonth!="") {
            criteriaUpdate.set("admissionYearMonth",newAdmissionYearMonth);
        }

        criteriaUpdate.where(cb.equal(root.get("id"),id));

        int i = em.createQuery(criteriaUpdate).executeUpdate();

        if(i==0) {

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("更新失敗，請聯絡管理員");

        } else {

            resultMsg.setVerifySuccess(true);
            resultMsg.setMessage("更新學生"+i+"筆成功");

        }

        return resultMsg;

    }
    public ActionResult deleteTeacherByid(Integer id) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Teacher> criteriaDelete = cb.createCriteriaDelete(Teacher.class);
        Root<Teacher> root = criteriaDelete.from(Teacher.class);
        //設置where條件
        Predicate[] predicates = new Predicate[2];
        predicates[0] = cb.equal(root.get("id"),id);
        predicates[1] = cb.equal(root.get("job"),"teacher");

        criteriaDelete.where(predicates);

        int i = em.createQuery(criteriaDelete).executeUpdate();

        if(i==0) {

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("刪除失敗，此id非老師身分或無此id");

        }else {

            resultMsg.setVerifySuccess(true);
            resultMsg.setMessage("刪除老師成功");

        }
        return resultMsg;
    }

    public ActionResult deleteStudentByid(Integer id) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Student> criteriaDelete = cb.createCriteriaDelete(Student.class);
        Root<Student> root = criteriaDelete.from(Student.class);
        //設置where條件
        Predicate[] predicates = new Predicate[2];
        predicates[0] = cb.equal(root.get("id"),id);
        predicates[1] = cb.equal(root.get("job"),"student");

        criteriaDelete.where(predicates);

        int i = em.createQuery(criteriaDelete).executeUpdate();

        if(i==0) {

            resultMsg.setVerifySuccess(false);
            resultMsg.setMessage("刪除失敗，此id非學生身分或無此id");

        }else {

            resultMsg.setVerifySuccess(true);
            resultMsg.setMessage("刪除學生成功");

        }

        return resultMsg;

    }





}
