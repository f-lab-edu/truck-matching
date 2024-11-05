package com.flab.moduleshipper.shipment.controller;

import com.flab.moduleshipper.shipment.dto.ShipmentDTO;
import com.flab.moduleshipper.shipment.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shipment")
public class ShipmentApiController {

    private final ShipmentService shipmentService;

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody ShipmentDTO.ShipmentRequest req) {
        String shipmentId = shipmentService.create(req);
        return ResponseEntity.status(HttpStatus.OK).body(shipmentId);
    }

    @GetMapping("/")
    public ResponseEntity<List<ShipmentDTO.BasicInfo>> getAll() {
        List<ShipmentDTO.BasicInfo> all = shipmentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @GetMapping("/{shipmentId}")
    public ResponseEntity<ShipmentDTO.BasicInfo> get(@PathVariable String shipmentId) {
        ShipmentDTO.BasicInfo basicInfo = shipmentService.get(shipmentId);
        return ResponseEntity.status(HttpStatus.OK).body(basicInfo);
    }
}
