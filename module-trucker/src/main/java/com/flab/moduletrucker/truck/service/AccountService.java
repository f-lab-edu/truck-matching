package com.flab.moduletrucker.truck.service;

import com.flab.moduletrucker.truck.domain.Account;
import com.flab.moduletrucker.truck.dto.TruckerDTO;
import com.flab.moduletrucker.truck.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Async(value = "taskExecutor")
    public String createAccount(TruckerDTO.AccountRequest req) {
        Account account = req.dtoToDomain(req);
        Account save = accountRepository.save(account);
        return save.getAccountId();
    }
}
