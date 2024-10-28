package com.flab.truck_matching.common.auth.service;

import com.flab.truck_matching.common.auth.JwtUtil;
import com.flab.truck_matching.member.domain.Member;
import com.flab.truck_matching.member.dto.MemberDTO;
import com.flab.truck_matching.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String login(MemberDTO.LoginReq req) {
        String memberInputId = req.getMemberInputId();
        String password = req.getPassword();

        Member member = memberRepository.findByMemberInputId(memberInputId);
        if (member == null) {
            throw new UsernameNotFoundException("로그인 아이디가 없습니다.");
        }

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.createAccessToken(member);
    }
}
