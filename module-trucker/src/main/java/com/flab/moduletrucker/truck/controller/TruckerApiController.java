package com.flab.moduletrucker.truck.controller;

import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.service.TruckerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trucker")
public class TruckerApiController {

    private final TruckerService truckerService;

    @PostMapping("/car")
    public ResponseEntity<String> createCar(@RequestBody TruckerDTO.CarRequest req) {
        String carId = truckerService.createCar(req);
        return ResponseEntity.status(HttpStatus.OK).body(carId);
    }

    @PostMapping("/contract")
    public ResponseEntity<String> createContract(@RequestBody TruckerDTO.ContractRequest req) {
        String contractId = truckerService.createContract(req);
        return ResponseEntity.status(HttpStatus.OK).body(contractId);
    }

}
