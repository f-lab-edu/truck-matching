package com.flab.moduleshipper.shipment.dto;

import com.flab.moduleshipper.shipment.domain.Shipment;
import lombok.Builder;
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

        public BasicInfo(Shipment shipment) {
            this.shipmentId = shipment.getShipmentId();
            this.memberId = shipment.getMemberId();
            this.companyName = shipment.getCompanyName();
            this.shipperName = shipment.getShipperName();
            this.businessRegistrationNumber = shipment.getBusinessRegistrationNumber();
            this.fromAddress = shipment.getFromAddress();
            this.toAddress = shipment.getToAddress();
            this.shipmentDate = shipment.getShipmentDate();
            this.shipmentType = shipment.getShipmentType();
            this.comment = shipment.getComment();
            this.shipmentStatus = shipment.getShipmentStatus();
        }
    }

    @Data
    @NoArgsConstructor
    public static class ShipmentRequest {
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

        public Shipment dtoToDomain(ShipmentDTO.ShipmentRequest req) {
            return Shipment.builder()
                    .memberId(req.getMemberId())
                    .shipperName(req.getShipperName())
                    .businessRegistrationNumber(req.getBusinessRegistrationNumber())
                    .fromAddress(req.getFromAddress())
                    .toAddress(req.getToAddress())
                    .shipmentDate(req.getShipmentDate())
                    .shipmentType(req.getShipmentType())
                    .comment(req.getComment())
                    .shipmentStatus("ready")
                    .build();
        }
    }

}
