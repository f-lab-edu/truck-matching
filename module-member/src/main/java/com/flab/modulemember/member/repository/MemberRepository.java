package com.flab.modulemember.member.repository;


import com.flab.modulemember.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByMemberInputId(String memberInputId);

}
