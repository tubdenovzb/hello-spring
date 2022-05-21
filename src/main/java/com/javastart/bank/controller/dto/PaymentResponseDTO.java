package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Payment;

public class PaymentResponseDTO {

    private Long paymentId;

    private Long accountId;

    private Long billId;

    private Integer amountOfPayment;

    public PaymentResponseDTO(Long paymentId, Long accountId, Long billId, Integer amountOfPayment) {
        this.paymentId = paymentId;
        this.accountId = accountId;
        this.billId = billId;
        this.amountOfPayment = amountOfPayment;
    }

    public PaymentResponseDTO(Payment payment) {
        paymentId = payment.getPaymentId();
        accountId = payment.getAccountId();
        billId = payment.getBillId();
        amountOfPayment = payment.getAmountOfPayment();
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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