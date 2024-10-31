package com.flab.truck_matching.common.auth.service;

import com.flab.modulemember.auth.service.AuthService;
import com.flab.modulemember.member.dto.MemberDTO;
import com.flab.modulemember.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    void 로그인_시_토큰_생성하는지_테스트() {
        MemberDTO.RegisterReq req = new MemberDTO.RegisterReq();
        req.setMemberInputId("testInputId");
        req.setPassword("testPassword");
        req.setEmail("testEmail@test.com");
        req.setAccountType("truck");
        memberService.create(req);

        MemberDTO.LoginReq loginReq = new  MemberDTO.LoginReq();
        loginReq.setMemberInputId("testInputId");
        loginReq.setPassword("testPassword");

        String token = authService.login(loginReq);
        Assertions.assertThat(token).isNotNull();
    }

}