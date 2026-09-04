package com.springtransaction.Transaction.Repository;

import com.springtransaction.Transaction.Entity.TransferRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRecordsRepository extends JpaRepository<TransferRecords,Integer> {
}
