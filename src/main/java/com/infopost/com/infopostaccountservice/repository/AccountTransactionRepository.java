package com.infopost.com.infopostaccountservice.repository;

import com.infopost.com.infopostaccountservice.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    List<AccountTransaction> findAllByUserAccountId(Long userId);
    // Здесь могут быть дополнительные методы для запросов, специфичных для AccountTransaction
}