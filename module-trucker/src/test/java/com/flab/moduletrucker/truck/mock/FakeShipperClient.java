package com.flab.moduletrucker.truck.mock;

import com.flab.moduletrucker.shipment.dto.ShipmentDTO;
import com.flab.moduletrucker.truck.feign.ShipperClient;
import org.springframework.http.ResponseEntity;

public class FakeShipperClient implements ShipperClient {

    @Override
    public ResponseEntity<ShipmentDTO.BasicInfo> get(String shipmentId) {
        ShipmentDTO.BasicInfo basicInfo = new ShipmentDTO.BasicInfo();
        switch (shipmentId) {
            case "ready":
                basicInfo.setShipmentId("ready");
                basicInfo.setShipmentStatus("ready");
                break;
            case "other":
                basicInfo.setShipmentId("other");
                basicInfo.setShipmentStatus("other");
                break;
        }

        return ResponseEntity.ok(basicInfo);
    }

    @Override
    public void shipmentStatus(String shipmentId, String status) {

    }
}
