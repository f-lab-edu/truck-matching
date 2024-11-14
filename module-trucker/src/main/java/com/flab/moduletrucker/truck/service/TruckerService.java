package com.flab.moduletrucker.truck.service;

import com.flab.moduletrucker.shipment.dto.ShipmentDTO;
import com.flab.moduletrucker.truck.domain.Car;
import com.flab.moduletrucker.truck.domain.Contract;
import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.feign.ShipperClient;
import com.flab.moduletrucker.truck.repository.CarRepository;
import com.flab.moduletrucker.truck.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TruckerService {

    private final CarRepository carRepository;
    private final ContractRepository contractRepository;
    private final ShipperClient shipperClient;

    public String createCar(TruckerDTO.CarRequest req) {
        Car car = req.dtoToDomain(req);
        Car save = carRepository.save(car);
        return save.getCarId();
    }

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
}
