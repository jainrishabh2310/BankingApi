package com.example.bankingapplication.banking.service;

import com.example.bankingapplication.banking.Dto.AccountDto;
import com.example.bankingapplication.banking.entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto creteAccount(AccountDto accountDto);
    AccountDto getbyid(Long id);
    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto> getAll();
    void deletebyid(Long id);
}
