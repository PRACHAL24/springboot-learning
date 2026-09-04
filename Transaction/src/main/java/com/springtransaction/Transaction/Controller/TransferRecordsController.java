package com.springtransaction.Transaction.Controller;

import com.springtransaction.Transaction.Entity.TransferRecords;
import com.springtransaction.Transaction.Services.TransferRecordsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transferRecords")
public class TransferRecordsController {
    private TransferRecordsServices transferRecordsServices;

    public TransferRecordsController(TransferRecordsServices transferRecordsServices) {
        this.transferRecordsServices = transferRecordsServices;
    }

    @PostMapping
    public ResponseEntity<String>records(@RequestBody TransferRecords transferRecords){
        transferRecordsServices.save(transferRecords.getFromAccNo(),
                transferRecords.getToAccNo(), transferRecords.getAmmount());
      return   ResponseEntity.ok("RECORD CREATED........");
    }
}
