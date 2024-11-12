package com.flab.moduletrucker.truck.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "CONTRACT")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String contractId;

    private String truckerMemberId;

    private String shipmentId;

    private String carId;

    private String contractStatus;

}
