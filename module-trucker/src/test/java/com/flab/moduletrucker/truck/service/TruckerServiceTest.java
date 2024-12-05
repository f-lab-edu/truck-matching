package com.flab.moduletrucker.truck.service;

import com.flab.moduletrucker.shipment.dto.ShipmentDTO;
import com.flab.moduletrucker.truck.domain.Contract;
import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.feign.ShipperClient;
import com.flab.moduletrucker.truck.mock.FakeShipperClient;
import com.flab.moduletrucker.truck.repository.AccountRepository;
import com.flab.moduletrucker.truck.repository.CarRepository;
import com.flab.moduletrucker.truck.repository.ContractRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TruckerServiceTest {

    @InjectMocks
    private AccountService accountService;

    @InjectMocks
    private CarService carService;

    @InjectMocks
    private ContractService contractService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private CarRepository carRepository;

    @Mock
    private ContractRepository contractRepository;

    @Mock
    private ShipperClient shipperClient;

    @Test
    void createContract_성공하는_경우() {
        TruckerDTO.ContractRequest req = new TruckerDTO.ContractRequest();
        req.setShipmentId("ready");
        ShipmentDTO.BasicInfo basicInfo = new ShipmentDTO.BasicInfo();
        basicInfo.setShipmentStatus("ready");
        ResponseEntity<ShipmentDTO.BasicInfo> basicInfoResponseEntity = new ResponseEntity<ShipmentDTO.BasicInfo>(basicInfo, HttpStatus.OK);
        Contract contract = Contract.builder().contractId("testId").build();

        when(shipperClient.get(req.getShipmentId())).thenReturn(basicInfoResponseEntity);
        when(contractRepository.save(any(Contract.class))).thenReturn(contract);

        String contractId = contractService.createContract(req);
        Assertions.assertNotNull(contractId);
    }

    @Test
    void createContract_shipment_ready가_아닌경우() {
        TruckerDTO.ContractRequest req = new TruckerDTO.ContractRequest();
        req.setShipmentId("other");
        ShipmentDTO.BasicInfo basicInfo = new ShipmentDTO.BasicInfo();
        basicInfo.setShipmentStatus("other");
        ResponseEntity<ShipmentDTO.BasicInfo> basicInfoResponseEntity = new ResponseEntity<ShipmentDTO.BasicInfo>(basicInfo, HttpStatus.OK);

        when(shipperClient.get(req.getShipmentId())).thenReturn(basicInfoResponseEntity);

        Assertions.assertThrows(RuntimeException.class, () -> {
            contractService.createContract(req);
        });
    }

}