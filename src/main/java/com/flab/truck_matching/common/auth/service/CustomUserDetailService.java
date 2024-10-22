package com.flab.truck_matching.common.auth.service;

import com.flab.truck_matching.common.auth.CustomUserDetails;
import com.flab.truck_matching.member.domain.Member;
import com.flab.truck_matching.member.dto.MemberDTO;
import com.flab.truck_matching.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저가 없습니다."));

        MemberDTO.BasicInfo basicInfo = new MemberDTO.BasicInfo();
        basicInfo.setMemberId(member.getMemberId());
        basicInfo.setMemberInputId(member.getMemberInputId());
        basicInfo.setAccountType(member.getAccountType());

        return new CustomUserDetails(basicInfo);
    }
}
