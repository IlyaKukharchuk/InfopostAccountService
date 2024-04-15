package com.infopost.com.infopostaccountservice.service.impl;

import com.infopost.com.infopostaccountservice.entity.UserAccount;
import com.infopost.com.infopostaccountservice.repository.UserAccountRepository;
import com.infopost.com.infopostaccountservice.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Override
    public UserAccount createUserAccount(UserAccount userAccount) {
        // Validate userAccount details here if needed
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount getUserAccountById(Long id) {
        return userAccountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("UserAccount not found")
        );
    }

    @Override
    public UserAccount creditAccount(Long id, BigDecimal amount) {
        UserAccount account = getUserAccountById(id);
        account.setBalance(account.getBalance().add(amount));
        return userAccountRepository.save(account);
    }

    @Override
    public UserAccount debitAccount(Long id, BigDecimal amount) {
        UserAccount account = getUserAccountById(id);
        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance().subtract(amount));
        return userAccountRepository.save(account);
    }
}
