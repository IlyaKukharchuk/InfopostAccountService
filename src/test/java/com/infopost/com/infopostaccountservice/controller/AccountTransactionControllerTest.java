package com.infopost.com.infopostaccountservice.controller;

import com.infopost.com.infopostaccountservice.entity.AccountTransaction;
import com.infopost.com.infopostaccountservice.service.AccountTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountTransactionControllerTest {

    @Mock
    private AccountTransactionService accountTransactionService;

    @InjectMocks
    private AccountTransactionController accountTransactionController;

    private AccountTransaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new AccountTransaction();
        // Set properties for the transaction object
    }

    @Test
    void createTransaction_Success() {
        when(accountTransactionService.createTransaction(any(AccountTransaction.class))).thenReturn(transaction);

        ResponseEntity<AccountTransaction> response = accountTransactionController.createTransaction(transaction);

        assertNotNull(response.getBody());
        // Add additional assertions for the properties of the transaction
    }

    @Test
    void getAllTransactionsForUser_Success() {
        List<AccountTransaction> transactionsList = Arrays.asList(transaction);
        when(accountTransactionService.getAllTransactionsForUser(eq(1L))).thenReturn(transactionsList);

        ResponseEntity<List<AccountTransaction>> response = accountTransactionController.getAllTransactionsForUser(1L);

        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
        // Add additional assertions for the properties of the transactions
    }
}
