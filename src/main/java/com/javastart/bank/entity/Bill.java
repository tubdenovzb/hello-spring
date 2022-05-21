package com.javastart.bank.entity;

import javax.persistence.*;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;

    private Long accountId;

    private Integer amount;

    public Bill(Long accountId, Integer amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public Bill() {
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long id) {
        this.billId = id;
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

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", accountId=" + accountId +
                ", amount=" + amount +
                '}';
    }
}