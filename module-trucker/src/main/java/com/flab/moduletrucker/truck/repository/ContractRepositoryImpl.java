package com.flab.moduletrucker.truck.repository;

import com.flab.moduletrucker.truck.domain.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ContractRepositoryImpl implements ContractRepository {

    private final ContractJpaRepository contractJpaRepository;

    @Override
    public Contract save(Contract contract) {
        return contractJpaRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(String contractId) {
        return contractJpaRepository.findById(contractId);
    }
}
