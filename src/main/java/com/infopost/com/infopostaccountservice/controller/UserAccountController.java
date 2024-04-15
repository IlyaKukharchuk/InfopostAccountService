package com.infopost.com.infopostaccountservice.controller;

import com.infopost.com.infopostaccountservice.entity.UserAccount;
import com.infopost.com.infopostaccountservice.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount userAccount) {
        UserAccount createdAccount = userAccountService.createUserAccount(userAccount);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserAccountById(@PathVariable Long id) {
        UserAccount account = userAccountService.getUserAccountById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/{id}/credit")
    public ResponseEntity<UserAccount> creditAccount(@PathVariable Long id, @RequestBody BigDecimal amount) {
        UserAccount updatedAccount = userAccountService.creditAccount(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    @PostMapping("/{id}/debit")
    public ResponseEntity<UserAccount> debitAccount(@PathVariable Long id, @RequestBody BigDecimal amount) {
        UserAccount updatedAccount = userAccountService.debitAccount(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }
}
