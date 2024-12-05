package com.flab.moduletrucker.truck.service;

import com.flab.moduletrucker.shipment.dto.ShipmentDTO;
import com.flab.moduletrucker.truck.domain.Contract;
import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.feign.ShipperClient;
import com.flab.moduletrucker.truck.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final ShipperClient shipperClient;

    @Async(value = "taskExecutor")
    public String createContract(TruckerDTO.ContractRequest req) {
        ResponseEntity<ShipmentDTO.BasicInfo> basicInfoResponseEntity = shipperClient.get(req.getShipmentId());
        ShipmentDTO.BasicInfo basicInfo = basicInfoResponseEntity.getBody();

        if ("ready".equals(basicInfo.getShipmentStatus())) {
            Contract contract = req.dtoToDomain(req);
            Contract save = contractRepository.save(contract);

            shipperClient.shipmentStatus(req.getShipmentId(), "delivery");
            return save.getContractId();
        } else {
            throw new RuntimeException("shipment status is not ready");
        }
    }

    @Async(value = "taskExecutor")
    public String updateContractStatus(String contractId, String status) {
        Optional<Contract> byId = contractRepository.findById(contractId);
        if (byId.isPresent()) {
            Contract contract = byId.get();
            contract.changeStatus(status);
            return status;
        } else {
            throw new RuntimeException("contract not found");
        }
    }

    @Async(value = "taskExecutor")
    public TruckerDTO.ContractResponse getContract(String contractId) {
        Optional<Contract> byId = contractRepository.findById(contractId);
        if (byId.isPresent()) {
            return new TruckerDTO.ContractResponse(byId.get());
        } else {
            throw new RuntimeException("contract not found");
        }
    }
}
