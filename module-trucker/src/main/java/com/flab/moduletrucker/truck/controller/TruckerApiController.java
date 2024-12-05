package com.flab.moduletrucker.truck.controller;

import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.service.AccountService;
import com.flab.moduletrucker.truck.service.CarService;
import com.flab.moduletrucker.truck.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trucker")
public class TruckerApiController {

    private final AccountService accountService;
    private final CarService carService;
    private final ContractService contractService;

    @PostMapping("/car")
    public ResponseEntity<String> createCar(@RequestBody TruckerDTO.CarRequest req) {
        String carId = carService.createCar(req);
        return ResponseEntity.status(HttpStatus.OK).body(carId);
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<TruckerDTO.CarInfo> getCar(@PathVariable String carId) {
        TruckerDTO.CarInfo car = carService.getCar(carId);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @PostMapping("/contract")
    public ResponseEntity<String> createContract(@RequestBody TruckerDTO.ContractRequest req) {
        String contractId = contractService.createContract(req);
        return ResponseEntity.status(HttpStatus.OK).body(contractId);
    }

    @PostMapping("/account")
    public ResponseEntity<String> createAccount(@RequestBody TruckerDTO.AccountRequest req) {
        String accountId = accountService.createAccount(req);
        return ResponseEntity.status(HttpStatus.OK).body(accountId);
    }

    @PutMapping("/contract/{contractId}/status/{status}")
    public ResponseEntity<String> updateContractStatus(@PathVariable String contractId, @PathVariable String status) {
        String resultStatus = contractService.updateContractStatus(contractId, status);
        return ResponseEntity.status(HttpStatus.OK).body(resultStatus);
    }

    @GetMapping("/contract/{contractId}")
    public ResponseEntity<TruckerDTO.ContractResponse> getContract(@PathVariable String contractId) {
        TruckerDTO.ContractResponse contractResponse = contractService.getContract(contractId);
        return ResponseEntity.status(HttpStatus.OK).body(contractResponse);
    }

}
