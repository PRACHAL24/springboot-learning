package com.springtransaction.Transaction.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class TransferRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private long fromAccNo;

    private long toAccNo;

    private BigDecimal ammount;
    private LocalDateTime transferAt=LocalDateTime.now();

    public TransferRecords( long fromAccNo, long toAccNo, BigDecimal ammount) {

        this.fromAccNo = fromAccNo;
        this.toAccNo = toAccNo;
        this.ammount = ammount;

    }
    public TransferRecords() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getFromAccNo() {
        return fromAccNo;
    }

    public void setFromAccNo(long fromAccNO) {
        this.fromAccNo = fromAccNO;
    }

    public long getToAccNo() {
        return toAccNo;
    }

    public void setToAccNo(long toAccNo) {
        this.toAccNo = toAccNo;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }


}
