package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Bill;

public class BillResponseDTO {

    private Long billId;

    private Long accountId;

    private Integer amount;

    public BillResponseDTO(Long billId, Long accountId, Integer amount) {
        this.billId = billId;
        this.accountId = accountId;
        this.amount = amount;
    }

    public BillResponseDTO(Bill bill) {
        billId = bill.getBillId();
        accountId = bill.getAccountId();
        amount = bill.getAmount();
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
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