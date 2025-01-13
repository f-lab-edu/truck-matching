package com.flab.moduleadmin.admin.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Shipment {

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

}
