package com.flab.moduletrucker.truck.mock;

import com.flab.moduletrucker.truck.domain.Account;
import com.flab.moduletrucker.truck.repository.AccountRepository;

public class FakeAccountRepository implements AccountRepository {


    @Override
    public Account save(Account account) {
        return Account.builder()
                .accountId("testAccountId")
                .accountNo(account.getAccountNo())
                .accountName(account.getAccountName())
                .accountBank(account.getAccountBank())
                .build();
    }
}
