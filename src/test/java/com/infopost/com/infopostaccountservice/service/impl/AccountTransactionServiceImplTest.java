package com.infopost.com.infopostaccountservice.service.impl;

import com.infopost.com.infopostaccountservice.entity.AccountTransaction;
import com.infopost.com.infopostaccountservice.repository.AccountTransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AccountTransactionServiceImplTest {

    @Mock
    private AccountTransactionRepository transactionRepository;

    @InjectMocks
    private AccountTransactionServiceImpl service;

    @BeforeEach
    void setUp() {
        // This is where we can set up mock behavior before each test
    }

    @Test
    void createTransaction_ShouldSaveTransaction() {
        AccountTransaction transaction = new AccountTransaction();
        when(transactionRepository.save(transaction)).thenReturn(transaction);

        AccountTransaction result = service.createTransaction(transaction);

        assertNotNull(result);
        verify(transactionRepository).save(transaction);
    }

    @Test
    void getAllTransactionsForUser_ShouldReturnTransactionList() {
        Long userId = 1L;
        List<AccountTransaction> expectedTransactions = Arrays.asList(new AccountTransaction(), new AccountTransaction());
        when(transactionRepository.findAllByUserAccountId(userId)).thenReturn(expectedTransactions);

        List<AccountTransaction> result = service.getAllTransactionsForUser(userId);

        assertEquals(expectedTransactions, result);
        verify(transactionRepository).findAllByUserAccountId(userId);
    }
}
