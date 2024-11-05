package com.flab.moduleshipper.shipment.service;

import com.flab.moduleshipper.shipment.domain.Shipment;
import com.flab.moduleshipper.shipment.dto.ShipmentDTO;
import com.flab.moduleshipper.shipment.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public String create(ShipmentDTO.ShipmentRequest req) {
        Shipment shipment = Shipment.builder().req(req).build();
        Shipment save = shipmentRepository.save(shipment);
        return save.getShipmentId();
    }

    public List<ShipmentDTO.BasicInfo> getAll() {
        List<Shipment> shipments = shipmentRepository.findAll();
        List<ShipmentDTO.BasicInfo> basicInfoList = new ArrayList<>();
        for (Shipment shipment : shipments) {
            ShipmentDTO.BasicInfo basicInfo = new ShipmentDTO.BasicInfo(shipment);
            basicInfoList.add(basicInfo);
        }
        return basicInfoList;
    }

    public ShipmentDTO.BasicInfo get(String shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId).orElse(null);
        if (shipment != null) {
            return new ShipmentDTO.BasicInfo(shipment);
        }
        return null;
    }
}
