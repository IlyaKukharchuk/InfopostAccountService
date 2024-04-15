package com.infopost.com.infopostaccountservice.repository;

import com.infopost.com.infopostaccountservice.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    // Здесь могут быть дополнительные методы для запросов, специфичных для UserAccount
}