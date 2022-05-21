package com.javastart.bank.controller.dto;

public class PaymentRequestDTO {

    private Long accountId;

    private Long billId;

    private Integer amountOfPayment;

    public PaymentRequestDTO(Long accountId, Long billId, Integer amountOfPayment) {
        this.accountId = accountId;
        this.billId = billId;
        this.amountOfPayment = amountOfPayment;
    }

    public PaymentRequestDTO() {
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

    public Integer getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(Integer amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }
}