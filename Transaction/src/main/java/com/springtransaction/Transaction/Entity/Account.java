package com.springtransaction.Transaction.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private  Integer accountNo;
    private BigDecimal balance;

    public Account(String name, Integer accountNo, BigDecimal balance) {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
    }
    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAcc_no() {
        return accountNo;
    }

    public void setAcc_no(Integer acc_no) {
        this.accountNo = acc_no;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void debitBalance(BigDecimal ammount){
        if(ammount==null && ammount.signum()<0){
            throw new RuntimeException("Ammount should be positive");
        }
        if(balance.compareTo(ammount)<0){
            throw new RuntimeException("Insufficient Balance");
        }
        balance=balance.subtract(ammount);

    }

    public void creditAccount(BigDecimal ammount){
        if(ammount==null && ammount.signum()<0){
            throw new RuntimeException("Ammount should be positive");
        }
        balance=balance.add(ammount);
    }
}
