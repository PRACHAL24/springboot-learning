package com.springtransaction.Transaction.Services;

import com.springtransaction.Transaction.Entity.Account;
import com.springtransaction.Transaction.Entity.TransferRecords;
import com.springtransaction.Transaction.Repository.AccountRepository;
import com.springtransaction.Transaction.Repository.TransferRecordsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferRecordsServices {

    private final TransferRecordsRepository transferRecordsRepository;
    private final AccountRepository accountRepository;

    public TransferRecordsServices(
            TransferRecordsRepository transferRecordsRepository,
            AccountRepository accountRepository) {

        this.transferRecordsRepository = transferRecordsRepository;
        this.accountRepository = accountRepository;
    }


    @Transactional
    public void save(long fromAccNo, long toAccNo, BigDecimal amount) {

        Account fromAcc = accountRepository.findByAccountNo(fromAccNo)
                .orElseThrow(() -> new RuntimeException("From Account Not Found"));

        Account toAcc = accountRepository.findByAccountNo(toAccNo)
                .orElseThrow(() -> new RuntimeException("To Account Not Found"));

        fromAcc.debitBalance(amount);

        toAcc.creditAccount(amount);

        transferRecordsRepository.save(
                new TransferRecords(fromAccNo, toAccNo, amount)
        );
    }

}