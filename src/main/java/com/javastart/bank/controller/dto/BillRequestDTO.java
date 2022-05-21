package com.javastart.bank.controller.dto;

public class BillRequestDTO {

    private Long accountId;

    private Integer amount;

    public BillRequestDTO(Long accountId, Integer amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public BillRequestDTO() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}