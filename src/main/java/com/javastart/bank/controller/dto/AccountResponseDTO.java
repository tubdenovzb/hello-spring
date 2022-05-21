package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Bill;

import java.util.List;

public class AccountResponseDTO {

    private Long accountId;

    private String name;

    private String email;

    private List<Bill> bills;

    public AccountResponseDTO(Long accountId, String name, String email, List<Bill> bills) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.bills = bills;
    }

    public AccountResponseDTO(Account account) {
        accountId = account.getAccountId();
        name = account.getName();
        email = account.getEmail();
        bills = account.getBills();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}