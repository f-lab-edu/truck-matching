package com.flab.moduletrucker.truck.service;

import com.flab.moduletrucker.shipment.dto.ShipmentDTO;
import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.mock.FakeAccountRepository;
import com.flab.moduletrucker.truck.mock.FakeCarRepository;
import com.flab.moduletrucker.truck.mock.FakeContractRepository;
import com.flab.moduletrucker.truck.mock.FakeShipperClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckerServiceTest {

    private TruckerService truckerService;

    @BeforeEach
    void setUp() throws Exception {
        this.truckerService = TruckerService.builder()
                .accountRepository(new FakeAccountRepository())
                .carRepository(new FakeCarRepository())
                .contractRepository(new FakeContractRepository())
                .shipperClient(new FakeShipperClient())
                .build();
    }

    @Test
    void createContract_성공하는_경우() {
        TruckerDTO.ContractRequest req = new TruckerDTO.ContractRequest();
        req.setShipmentId("ready");
        String contractId = truckerService.createContract(req);
        Assertions.assertNotNull(contractId);
    }

    @Test
    void createContract_shipment_ready가_아닌경우() {
        TruckerDTO.ContractRequest req = new TruckerDTO.ContractRequest();
        req.setShipmentId("other");
        Assertions.assertThrows(RuntimeException.class, () -> {
            truckerService.createContract(req);
        });
    }

}