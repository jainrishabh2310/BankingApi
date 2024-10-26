package com.example.bankingapplication.banking.repository;

import com.example.bankingapplication.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
