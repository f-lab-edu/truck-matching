package com.flab.moduletrucker.truck.dto;

import com.flab.moduletrucker.truck.domain.Car;
import com.flab.moduletrucker.truck.domain.Contract;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TruckerDTO {

    @Data
    @NoArgsConstructor
    public static class CarRequest {
        private String memberId;
        private String carType;

        public Car dtoToDomain(TruckerDTO.CarRequest req) {
            return Car.builder()
                    .memberId(req.getMemberId())
                    .carType(req.getCarType())
                    .build();
        }
    }

    @Data
    @NoArgsConstructor
    public static class ContractRequest {
        private String truckerMemberId;
        private String shipmentId;
        private String carId;
        private String contractStatus;

        public Contract dtoToDomain(TruckerDTO.ContractRequest req) {
            return Contract.builder()
                    .truckerMemberId(req.getTruckerMemberId())
                    .shipmentId(req.getShipmentId())
                    .carId(req.getCarId())
                    .contractStatus("concluded")
                    .build();
        }
    }

}
