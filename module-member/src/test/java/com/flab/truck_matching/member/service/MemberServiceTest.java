package com.flab.truck_matching.member.service;

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
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    void 멤버_제대로_생성하는지_테스트() {
        MemberDTO.RegisterReq req = new MemberDTO.RegisterReq();
        req.setMemberInputId("testInputId");
        req.setPassword("testPassword");
        req.setEmail("testEmail@test.com");
        req.setAccountType("truck");
        String memberId = memberService.create(req);
        Assertions.assertThat(memberId).isNotNull();
    }

}