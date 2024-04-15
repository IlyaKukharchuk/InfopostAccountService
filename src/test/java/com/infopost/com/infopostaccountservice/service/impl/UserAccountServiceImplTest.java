package com.infopost.com.infopostaccountservice.service.impl;

import com.infopost.com.infopostaccountservice.entity.UserAccount;
import com.infopost.com.infopostaccountservice.repository.UserAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceImplTest {

    @Mock
    private UserAccountRepository userAccountRepository;

    @InjectMocks
    private UserAccountServiceImpl userAccountService;

    private UserAccount userAccount;

    @BeforeEach
    void setUp() {
        userAccount = UserAccount.builder()
                .id(1L)
                .username("testuser")
                .balance(new BigDecimal("100.00"))
                .build();
    }

    @Test
    void createUserAccount_Success() {
        when(userAccountRepository.save(any(UserAccount.class))).thenReturn(userAccount);

        UserAccount created = userAccountService.createUserAccount(userAccount);

        assertNotNull(created);
        assertEquals(userAccount.getUsername(), created.getUsername());
        assertEquals(userAccount.getBalance(), created.getBalance());
    }

    @Test
    void getUserAccountById_Found() {
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(userAccount));

        UserAccount found = userAccountService.getUserAccountById(1L);

        assertNotNull(found);
        assertEquals(userAccount.getId(), found.getId());
    }

    @Test
    void getUserAccountById_NotFound() {
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userAccountService.getUserAccountById(1L);
        });

        assertEquals("UserAccount not found", exception.getMessage());
    }

    @Test
    void creditAccount_Success() {
        BigDecimal creditAmount = new BigDecimal("50.00");
        BigDecimal expectedBalance = userAccount.getBalance().add(creditAmount);

        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(userAccount));
        when(userAccountRepository.save(any(UserAccount.class))).thenReturn(userAccount);

        UserAccount updated = userAccountService.creditAccount(1L, creditAmount);

        assertNotNull(updated);
        assertEquals(expectedBalance, updated.getBalance());
    }

    @Test
    void debitAccount_Success() {
        BigDecimal debitAmount = new BigDecimal("50.00");
        BigDecimal expectedBalance = userAccount.getBalance().subtract(debitAmount);

        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(userAccount));
        when(userAccountRepository.save(any(UserAccount.class))).thenReturn(userAccount);

        UserAccount updated = userAccountService.debitAccount(1L, debitAmount);

        assertNotNull(updated);
        assertEquals(expectedBalance, updated.getBalance());
    }

    @Test
    void debitAccount_InsufficientBalance() {
        BigDecimal debitAmount = new BigDecimal("150.00");

        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(userAccount));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userAccountService.debitAccount(1L, debitAmount);
        });

        assertEquals("Insufficient balance", exception.getMessage());
    }
}
