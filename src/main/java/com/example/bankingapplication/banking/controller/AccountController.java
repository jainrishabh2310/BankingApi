package com.example.bankingapplication.banking.controller;

import com.example.bankingapplication.banking.Dto.AccountDto;
import com.example.bankingapplication.banking.entity.Account;
import com.example.bankingapplication.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public ResponseEntity<AccountDto> addAccount( @RequestBody  AccountDto accountDto){
        return  new ResponseEntity<>(accountService.creteAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findbyid(@PathVariable Long id){
        AccountDto accountDto=accountService.getbyid(id);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                             @RequestBody Map<String,Double> request){
        double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                              @RequestBody Map<String,Double> request){
        double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("")
    public ResponseEntity<List<AccountDto>> getAll(){
        List<AccountDto> accountDto=accountService.getAll();
        return ResponseEntity.ok(accountDto);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deletebyid( @PathVariable Long id){
        accountService.deletebyid(id);
        return ResponseEntity.ok("account is deleetd");
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }


}
