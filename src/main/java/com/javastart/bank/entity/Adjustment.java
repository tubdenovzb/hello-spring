package com.javastart.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adjustmentId;

    private Long accountId;

    private Long billId;

    private Integer amountOfAdjustment;

    public Adjustment(Long accountId, Long billId, Integer amountOfAdjustment) {
        this.accountId = accountId;
        this.billId = billId;
        this.amountOfAdjustment = amountOfAdjustment;
    }

    public Adjustment() {
    }

    public Long getAdjustmentId() {
        return adjustmentId;
    }

    public void setAdjustmentId(Long adjustmentId) {
        this.adjustmentId = adjustmentId;
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

    @Override
    public String toString() {
        return "Adjustment{" +
                "adjustmentId=" + adjustmentId +
                ", accountId=" + accountId +
                ", billId=" + billId +
                ", amountOfAdjustment=" + amountOfAdjustment +
                '}';
    }
}