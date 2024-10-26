package com.example.bankingapplication.banking.service.impl;

import com.example.bankingapplication.banking.Dto.AccountDto;
import com.example.bankingapplication.banking.MApper.AccountMapper;
import com.example.bankingapplication.banking.entity.Account;
import com.example.bankingapplication.banking.repository.AccountRepo;
import com.example.bankingapplication.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

   // CREATE ACCOUNT REST API
    @Override
    public AccountDto creteAccount(AccountDto accountDto) {
        Account account= AccountMapper.maptoAccount(accountDto);
        Account saved=accountRepo.save(account);
        return AccountMapper.maptoAccountRto(saved);
    }

    // GET ACCOUNT BY ID REST API
    @Override
    public AccountDto getbyid(Long id) {
        Account account = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist"));
        return AccountMapper.maptoAccountRto(account);
    }

   // Deposit Amount REST API
    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist"));
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account account1=accountRepo.save(account);
        return AccountMapper.maptoAccountRto(account1);
    }

    // Withdraw Amount REST API
    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist"));
        if(account.getBalance()<amount){
            throw new RuntimeException("amount is not available");
        }
        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account account1=accountRepo.save(account);
        return AccountMapper.maptoAccountRto(account1);
    }

    // Get All Account REST API
    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts=accountRepo.findAll();
        return accounts.stream().map((account)-> AccountMapper.maptoAccountRto(account))
                .collect(Collectors.toList());
    }

    // Delete Account By ID REST API
    @Override
    public void deletebyid(Long id) {
        Account account = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not exist"));
        accountRepo.deleteById(id);

    }
}
