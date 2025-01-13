package com.flab.moduletrucker.truck.repository;

import com.flab.moduletrucker.truck.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
