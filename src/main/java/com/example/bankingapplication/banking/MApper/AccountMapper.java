package com.example.bankingapplication.banking.MApper;

import com.example.bankingapplication.banking.Dto.AccountDto;
import com.example.bankingapplication.banking.entity.Account;

public class AccountMapper {

    public static Account maptoAccount(AccountDto accountDto){
        Account account=new Account(accountDto.getId()
        ,accountDto.getAccountHoldername(),accountDto.getBalance())
                ;
        return account;
    }

    public static AccountDto maptoAccountRto(Account account){
        AccountDto accountDto=new AccountDto(account.getId()
                ,account.getAccountHoldername(),account.getBalance())
                ;
        return accountDto;
    }
}
