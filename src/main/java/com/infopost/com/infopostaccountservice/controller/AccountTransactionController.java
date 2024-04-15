package com.infopost.com.infopostaccountservice.controller;

import com.infopost.com.infopostaccountservice.entity.AccountTransaction;
import com.infopost.com.infopostaccountservice.service.AccountTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class AccountTransactionController {

    private final AccountTransactionService accountTransactionService;

    @PostMapping
    public ResponseEntity<AccountTransaction> createTransaction(@RequestBody AccountTransaction transaction) {
        AccountTransaction createdTransaction = accountTransactionService.createTransaction(transaction);
        return ResponseEntity.ok(createdTransaction);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AccountTransaction>> getAllTransactionsForUser(@PathVariable Long userId) {
        List<AccountTransaction> transactions = accountTransactionService.getAllTransactionsForUser(userId);
        return ResponseEntity.ok(transactions);
    }
}
