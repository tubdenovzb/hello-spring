package com.javastart.bank.controller;

import com.javastart.bank.controller.dto.AccountRequestDTO;
import com.javastart.bank.controller.dto.AccountResponseDTO;
import com.javastart.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    private Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO.getName(),
                accountRequestDTO.getEmail(), accountRequestDTO.getBills());
    }

    @GetMapping("/accounts/{id}")
    private AccountResponseDTO getAccount(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.getAccountById(id));
    }

    @PutMapping("/accounts/{id}")
    public AccountResponseDTO updateAccount(@PathVariable Long id, @RequestBody AccountRequestDTO accountRequestDTO) {
        return new AccountResponseDTO(accountService.updateAccount(id, accountRequestDTO.getName(),
                accountRequestDTO.getEmail()));
    }

    @DeleteMapping("/accounts/{id}")
    public Long deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }
}