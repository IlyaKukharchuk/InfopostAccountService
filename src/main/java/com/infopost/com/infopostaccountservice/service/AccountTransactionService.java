package com.infopost.com.infopostaccountservice.service;

import com.infopost.com.infopostaccountservice.entity.AccountTransaction;

import java.util.List;

public interface AccountTransactionService {
    AccountTransaction createTransaction(AccountTransaction transaction);
    List<AccountTransaction> getAllTransactionsForUser(Long userId);
}
