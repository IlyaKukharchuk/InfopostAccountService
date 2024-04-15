package com.infopost.com.infopostaccountservice.service.impl;

import com.infopost.com.infopostaccountservice.entity.AccountTransaction;
import com.infopost.com.infopostaccountservice.repository.AccountTransactionRepository;
import com.infopost.com.infopostaccountservice.service.AccountTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountTransactionServiceImpl implements AccountTransactionService {

    private final AccountTransactionRepository transactionRepository;

    @Override
    public AccountTransaction createTransaction(AccountTransaction transaction) {
        // Validate transaction details here if needed
        return transactionRepository.save(transaction);
    }

    @Override
    public List<AccountTransaction> getAllTransactionsForUser(Long userId) {
        // Assuming that you have a method in your repository to find transactions by user ID
        return transactionRepository.findAllByUserAccountId(userId);
    }
}
