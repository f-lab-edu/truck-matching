package com.flab.moduleshipper.shipment.dto;

import com.flab.moduleshipper.shipment.domain.Shipment;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ShipmentDTO {

    @Data
    @NoArgsConstructor
    public static class BasicInfo {
        private String shipmentId;
        private String companyName;
        private String shipperName;
        private String businessRegistrationNumber;
        private String fromAddress;
        private String toAddress;
        private String shipmentDate;
        private String shipmentType;
        private String comment;

        public BasicInfo(Shipment shipment) {
            this.shipmentId = shipment.getShipmentId();
            this.companyName = shipment.getCompanyName();
            this.shipperName = shipment.getShipperName();
            this.businessRegistrationNumber = shipment.getBusinessRegistrationNumber();
            this.fromAddress = shipment.getFromAddress();
            this.toAddress = shipment.getToAddress();
            this.shipmentDate = shipment.getShipmentDate();
            this.shipmentType = shipment.getShipmentType();
            this.comment = shipment.getComment();
        }
    }

    @Data
    @NoArgsConstructor
    public static class ShipmentRequest {
        private String companyName;
        private String shipperName;
        private String businessRegistrationNumber;
        private String fromAddress;
        private String toAddress;
        private String shipmentDate;
        private String shipmentType;
        private String comment;
    }

}
