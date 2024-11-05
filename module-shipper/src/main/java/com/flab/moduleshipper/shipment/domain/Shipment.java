package com.flab.moduleshipper.shipment.domain;

import com.flab.moduleshipper.shipment.dto.ShipmentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "SHIPMENT")
@NoArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String shipmentId;

    private String companyName;

    private String shipperName;

    private String businessRegistrationNumber;

    private String fromAddress;

    private String toAddress;

    private String shipmentDate;

    private String shipmentType;

    private String comment;

    @Builder
    public Shipment(ShipmentDTO.ShipmentRequest req) {
        this.companyName = req.getCompanyName();
        this.shipperName = req.getShipperName();
        this.businessRegistrationNumber = req.getBusinessRegistrationNumber();
        this.fromAddress = req.getFromAddress();
        this.toAddress = req.getToAddress();
        this.shipmentDate = req.getShipmentDate();
        this.shipmentType = req.getShipmentType();
        this.comment = req.getComment();
    }
}
