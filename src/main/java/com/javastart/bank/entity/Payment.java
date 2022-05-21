package com.javastart.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    private Long accountId;

    private Long billId;

    private Integer amountOfPayment;

    public Payment(Long accountId, Long billId, Integer amountOfPayment) {
        this.accountId = accountId;
        this.billId = billId;
        this.amountOfPayment = amountOfPayment;
    }

    public Payment() {
    }

    public Long getPaymentId() {
        return paymentId;
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

    public void setAmountOfPayment(Integer amount) {
        this.amountOfPayment = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", accountId=" + accountId +
                ", billId=" + billId +
                ", amount=" + amountOfPayment +
                '}';
    }
}