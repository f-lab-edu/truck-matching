package com.flab.moduleshipper.shipment.controller;

import com.flab.moduleshipper.shipment.dto.ShipmentDTO;
import com.flab.moduleshipper.shipment.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
    public CompletableFuture<ResponseEntity<List<ShipmentDTO.BasicInfo>>> getAll() {
        return shipmentService.getAll()
                .thenApply(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/{shipmentId}")
    public ResponseEntity<ShipmentDTO.BasicInfo> get(@PathVariable String shipmentId) {
        ShipmentDTO.BasicInfo basicInfo = shipmentService.get(shipmentId);
        return ResponseEntity.status(HttpStatus.OK).body(basicInfo);
    }

    @PutMapping("/{shipmentId}/shipment-status/{status}")
    public void updateStatus(@PathVariable String shipmentId, @PathVariable String status) {
        shipmentService.updateStatus(shipmentId, status);
    }
}
