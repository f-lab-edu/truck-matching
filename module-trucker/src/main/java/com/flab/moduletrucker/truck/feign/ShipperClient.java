package com.flab.moduletrucker.truck.feign;

import com.flab.moduletrucker.shipment.dto.ShipmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "shipperClient", url = "http://localhost:8001/api/v1/shipment")
public interface ShipperClient {

    @GetMapping(value = "/{shipmentId}")
    ResponseEntity<ShipmentDTO.BasicInfo> get(@PathVariable("shipmentId") String shipmentId);

    @PutMapping(value = "/{shipmentId}/shipment-status/{status}")
    void shipmentStatus(@PathVariable("shipmentId") String shipmentId, @PathVariable("status") String status);
}
