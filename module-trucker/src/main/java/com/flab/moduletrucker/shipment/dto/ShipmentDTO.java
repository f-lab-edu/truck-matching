package com.flab.moduletrucker.shipment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ShipmentDTO {

    @Data
    @NoArgsConstructor
    public static class BasicInfo {
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

}
