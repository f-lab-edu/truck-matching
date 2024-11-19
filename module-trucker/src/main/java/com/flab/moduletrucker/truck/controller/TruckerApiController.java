package com.flab.moduletrucker.truck.controller;

import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.service.TruckerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/car/{carId}")
    public ResponseEntity<TruckerDTO.CarInfo> getCar(@PathVariable String carId) {
        TruckerDTO.CarInfo car = truckerService.getCar(carId);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @PostMapping("/contract")
    public ResponseEntity<String> createContract(@RequestBody TruckerDTO.ContractRequest req) {
        String contractId = truckerService.createContract(req);
        return ResponseEntity.status(HttpStatus.OK).body(contractId);
    }

    @PostMapping("/account")
    public ResponseEntity<String> createAccount(@RequestBody TruckerDTO.AccountRequest req) {
        String accountId = truckerService.createAccount(req);
        return ResponseEntity.status(HttpStatus.OK).body(accountId);
    }

    @PutMapping("/contract/{contractId}/status/{status}")
    public ResponseEntity<String> updateContractStatus(@PathVariable String contractId, @PathVariable String status) {
        String resultStatus = truckerService.updateContractStatus(contractId, status);
        return ResponseEntity.status(HttpStatus.OK).body(resultStatus);
    }

}
