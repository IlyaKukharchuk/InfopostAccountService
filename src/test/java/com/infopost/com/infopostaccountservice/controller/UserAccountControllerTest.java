package com.infopost.com.infopostaccountservice.controller;

import com.infopost.com.infopostaccountservice.entity.UserAccount;
import com.infopost.com.infopostaccountservice.service.UserAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserAccountControllerTest {

    @Mock
    private UserAccountService userAccountService;

    @InjectMocks
    private UserAccountController userAccountController;

    private UserAccount userAccount;

    @BeforeEach
    void setUp() {
        userAccount = new UserAccount();
        userAccount.setId(1L);
        userAccount.setUsername("testuser");
        userAccount.setBalance(new BigDecimal("100.00"));
    }

    @Test
    void createUserAccount_Success() {
        when(userAccountService.createUserAccount(any(UserAccount.class))).thenReturn(userAccount);

        ResponseEntity<UserAccount> response = userAccountController.createUserAccount(userAccount);

        assertNotNull(response.getBody());
        assertEquals(userAccount.getUsername(), response.getBody().getUsername());
        assertEquals(userAccount.getBalance(), response.getBody().getBalance());
    }

    @Test
    void getUserAccountById_Success() {
        when(userAccountService.getUserAccountById(eq(1L))).thenReturn(userAccount);

        ResponseEntity<UserAccount> response = userAccountController.getUserAccountById(1L);

        assertNotNull(response.getBody());
        assertEquals(userAccount.getId(), response.getBody().getId());
    }

    @Test
    void creditAccount_Success() {
        BigDecimal creditAmount = new BigDecimal("50.00");
        when(userAccountService.creditAccount(eq(1L), eq(creditAmount))).thenReturn(userAccount);

        ResponseEntity<UserAccount> response = userAccountController.creditAccount(1L, creditAmount);

        assertNotNull(response.getBody());
        assertEquals(userAccount.getBalance(), response.getBody().getBalance());
    }

    @Test
    void debitAccount_Success() {
        BigDecimal debitAmount = new BigDecimal("50.00");
        when(userAccountService.debitAccount(eq(1L), eq(debitAmount))).thenReturn(userAccount);

        ResponseEntity<UserAccount> response = userAccountController.debitAccount(1L, debitAmount);

        assertNotNull(response.getBody());
        assertEquals(userAccount.getBalance(), response.getBody().getBalance());
    }
}
