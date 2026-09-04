package com.springtransaction.Transaction.Controller;

import com.springtransaction.Transaction.Entity.Account;
import com.springtransaction.Transaction.Services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<String>craeteAccount(@RequestBody Account account){
        accountService.create(account);
        return ResponseEntity.ok("ACCOUNT CREATED....");
    }


}
