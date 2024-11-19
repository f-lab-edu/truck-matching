package com.flab.moduletrucker.truck.repository;

import com.flab.moduletrucker.truck.domain.Contract;

import java.util.Optional;

public interface ContractRepository {
    Contract save(Contract contract);

    Optional<Contract> findById(String contractId);
}
