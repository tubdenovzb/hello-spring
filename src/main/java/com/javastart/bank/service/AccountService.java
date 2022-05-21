package com.javastart.bank.service;

import com.javastart.bank.dao.AccountDAO;
import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountDAO accountDAO;

    @Autowired
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Long createAccount(String name, String email, List<Bill> bills) {
        Account account = new Account(name, email, bills);
        return accountDAO.save(account).getAccountId();
    }

    public Account getAccountById(Long accountId) {
        Account account = accountDAO.findById(accountId);
        if (account == null) {
            throw new AccountNotFoundException("Can't find account with id: " + accountId);
        }
        return account;
    }

    public Account updateAccount(Long accountId, String name, String email) {
        Account account = getAccountById(accountId);
        account.setName(name);
        account.setEmail(email);
        accountDAO.update(account);
        return account;
    }

    public void addBillToAccount(Long accountId, Bill bill) {
        getAccountById(accountId);
        accountDAO.addBill(accountId, bill);
    }

    public Long deleteAccount(Long accountId) {
        getAccountById(accountId);
        accountDAO.delete(accountId);
        return accountId;
    }
}