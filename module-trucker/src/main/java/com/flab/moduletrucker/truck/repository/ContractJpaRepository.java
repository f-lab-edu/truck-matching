package com.flab.moduletrucker.truck.repository;

import com.flab.moduletrucker.truck.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractJpaRepository extends JpaRepository<Contract, String> {


}
