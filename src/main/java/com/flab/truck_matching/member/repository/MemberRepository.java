package com.flab.truck_matching.member.repository;

import com.flab.truck_matching.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {



}
