package com.flab.modulemember.member.service;

import com.flab.modulemember.member.domain.Member;
import com.flab.modulemember.member.dto.MemberDTO;
import com.flab.modulemember.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    public String create(MemberDTO.RegisterReq req) {
        req.setPassword(encoder.encode(req.getPassword()));

        Member member = req.dtoToDomain(req);
        memberRepository.save(member);
        return member.getMemberId();
    }
}
