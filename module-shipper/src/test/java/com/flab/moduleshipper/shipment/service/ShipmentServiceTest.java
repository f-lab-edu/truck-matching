package com.flab.moduleshipper.shipment.service;

import com.flab.moduleshipper.shipment.dto.ShipmentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShipmentServiceTest {

    @Autowired
    private ShipmentService shipmentService;

    @Test
    void create() {
        ShipmentDTO.ShipmentRequest req = new ShipmentDTO.ShipmentRequest();
        req.setMemberId("testMemberId");
        shipmentService.create(req);
    }
}