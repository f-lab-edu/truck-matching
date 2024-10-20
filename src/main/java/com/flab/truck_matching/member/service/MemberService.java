package com.flab.truck_matching.member.service;

import com.flab.truck_matching.member.domain.Member;
import com.flab.truck_matching.member.dto.MemberDTO;
import com.flab.truck_matching.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String addMember(MemberDTO.RegisterReq req) {
        Member member = Member.builder().req(req).build();
        memberRepository.save(member);
        return member.getUserId();
    }
}
