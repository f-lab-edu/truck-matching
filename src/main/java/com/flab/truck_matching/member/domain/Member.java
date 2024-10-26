package com.flab.truck_matching.member.domain;

import com.flab.truck_matching.member.dto.MemberDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Entity(name = "MEMBER")
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String memberId;

    private String memberInputId;

    private String password;

    private String email;

    private String phoneNumber;

    private String accountType;

    private String created;

    private String updated;

    @Builder
    public Member(MemberDTO.RegisterReq req) {
        this.memberInputId = req.getMemberInputId();
        this.password = req.getPassword();
        this.email = req.getEmail();
        this.phoneNumber = req.getPhoneNumber();
        this.accountType = req.getAccountType();
        this.created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.updated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
