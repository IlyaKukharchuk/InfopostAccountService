package com.infopost.com.infopostaccountservice.service;

import com.infopost.com.infopostaccountservice.entity.UserAccount;
import java.math.BigDecimal;

public interface UserAccountService {
    UserAccount createUserAccount(UserAccount userAccount);
    UserAccount getUserAccountById(Long id);
    UserAccount creditAccount(Long id, BigDecimal amount);
    UserAccount debitAccount(Long id, BigDecimal amount);
}
