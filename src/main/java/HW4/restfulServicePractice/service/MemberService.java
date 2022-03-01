package HW4.restfulServicePractice.service;

import HW4.restfulServicePractice.model.Member;
import HW4.restfulServicePractice.repository.MemberListRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.security.PrivateKey;
import java.util.List;


@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberListRepo mListRepo;

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

        //利用predicate 下多條件
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




}
