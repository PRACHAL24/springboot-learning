package com.springtransaction.Transaction.Services;

import com.springtransaction.Transaction.Entity.Account;
import com.springtransaction.Transaction.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void create(Account account){
        accountRepository.save(account);
    }
}
