package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Bill;

import java.util.List;

public class AccountRequestDTO {

    private String name;

    private String email;

    private List<Bill> bills;

    public AccountRequestDTO(String name, String email, List<Bill> bills) {
        this.name = name;
        this.email = email;
        this.bills = bills;
    }

    public AccountRequestDTO() {
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