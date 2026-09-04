package com.springtransaction.Transaction.Repository;

import com.springtransaction.Transaction.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {


  Optional<Account> findByAccountNo(long fromAccNo);
}
