package com.flab.moduleshipper.shipment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "SHIPMENT")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String shipmentId;

    private String memberId;

    private String companyName;

    private String shipperName;

    private String businessRegistrationNumber;

    private String fromAddress;

    private String toAddress;

    private String shipmentDate;

    private String shipmentType;

    private String comment;

    private String shipmentStatus;

    public void changeStatus(String status) {
        this.shipmentStatus = status;
    }
}
