package com.flab.truck_matching.member.repository;

import com.flab.modulemember.member.domain.Member;
import com.flab.modulemember.member.dto.MemberDTO;
import com.flab.modulemember.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = true)
@TestPropertySource("classpath:test-application.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    void MemberRepository_에_데이터가_잘_들어가는지() {
        // given
        MemberDTO.RegisterReq req = new MemberDTO.RegisterReq();
        req.setMemberInputId("testMemberInputId");
        req.setPassword("testPassword");
        req.setEmail("testEmail@email.com");
        req.setPhoneNumber("testPhoneNumber");
        req.setAccountType("truck");
        Member member = Member.builder()
                .req(req)
                .build();

        // when
        Member save = memberRepository.save(member);

        // then
        assertThat(save.getMemberId()).isNotNull();
    }

}