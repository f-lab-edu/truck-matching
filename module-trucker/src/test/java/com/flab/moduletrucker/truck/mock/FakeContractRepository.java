package com.flab.moduletrucker.truck.mock;

import com.flab.moduletrucker.truck.domain.Contract;
import com.flab.moduletrucker.truck.repository.ContractRepository;

import java.util.Optional;

public class FakeContractRepository implements ContractRepository {

    @Override
    public Contract save(Contract contract) {
        return Contract.builder()
                .contractId("testContractId")
                .contractStatus("concluded")
                .build();
    }

    @Override
    public Optional<Contract> findById(String contractId) {
        return Optional.empty();
    }
}
