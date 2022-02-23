package HW4.restfulServicePractice.repository;

import HW4.restfulServicePractice.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberListRepo extends JpaRepository<Member,Integer> {
    @Query(value = " select * from Member m", nativeQuery = true)
//    @Query(value = " from Member", nativeQuery = false)
    public List<Member> getAllMember();

}
