package com.flab.moduletrucker.truck.dto;

import com.flab.moduletrucker.truck.domain.Account;
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
    public static class CarInfo {
        private String carId;
        private String memberId;
        private String carType;

        public CarInfo(Car car) {
            this.carId = car.getCarId();
            this.memberId = car.getMemberId();
            this.carType = car.getCarType();
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

    @Data
    @NoArgsConstructor
    public static class AccountRequest {
        private String accountNo;
        private String accountName;
        private String accountBank;

        public Account dtoToDomain(TruckerDTO.AccountRequest req) {
            return Account.builder()
                    .accountNo(req.getAccountNo())
                    .accountName(req.getAccountName())
                    .accountBank(req.getAccountBank())
                    .build();
        }
    }

    @Data
    @NoArgsConstructor
    public static class ContractResponse {
        private String contractId;
        private String truckerMemberId;
        private String shipmentId;
        private String carId;
        private String contractStatus;

        public ContractResponse(Contract contract) {
            this.contractId = contract.getContractId();
            this.truckerMemberId = contract.getTruckerMemberId();
            this.shipmentId = contract.getShipmentId();
            this.carId = contract.getCarId();
            this.contractStatus = contract.getContractStatus();
        }
    }

}
