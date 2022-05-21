package com.javastart.bank.controller.dto;

public class AdjustmentRequestDTO {

    private Long accountId;

    private Long billId;

    private Integer amountOfAdjustment;

    public AdjustmentRequestDTO(Long accountId, Long billId, Integer amountOfAdjustment) {
        this.accountId = accountId;
        this.billId = billId;
        this.amountOfAdjustment = amountOfAdjustment;
    }

    public AdjustmentRequestDTO() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Integer getAmountOfAdjustment() {
        return amountOfAdjustment;
    }

    public void setAmountOfAdjustment(Integer amountOfAdjustment) {
        this.amountOfAdjustment = amountOfAdjustment;
    }
}