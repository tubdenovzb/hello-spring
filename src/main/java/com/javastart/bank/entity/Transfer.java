package com.javastart.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transferId;

    private Long remitterAccountId;

    private Long remitterBillId;

    private Long recipientAccountId;

    private Long recipientBillId;

    private Integer amountOfTransfer;

    public Transfer(Long remitterAccountId, Long remitterBillId, Long recipientAccountId, Long recipientBillId, Integer amountOfTransfer) {
        this.remitterAccountId = remitterAccountId;
        this.remitterBillId = remitterBillId;
        this.recipientAccountId = recipientAccountId;
        this.recipientBillId = recipientBillId;
        this.amountOfTransfer = amountOfTransfer;
    }

    public Transfer() {
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Long getRemitterAccountId() {
        return remitterAccountId;
    }

    public void setRemitterAccountId(Long remitterAccountId) {
        this.remitterAccountId = remitterAccountId;
    }

    public Long getRemitterBillId() {
        return remitterBillId;
    }

    public void setRemitterBillId(Long remitterBillId) {
        this.remitterBillId = remitterBillId;
    }

    public Long getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(Long recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }

    public Long getRecipientBillId() {
        return recipientBillId;
    }

    public void setRecipientBillId(Long recipientBillId) {
        this.recipientBillId = recipientBillId;
    }

    public Integer getAmountOfTransfer() {
        return amountOfTransfer;
    }

    public void setAmountOfTransfer(Integer amountOfTransfer) {
        this.amountOfTransfer = amountOfTransfer;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", remitterAccountId=" + remitterAccountId +
                ", remitterBillId=" + remitterBillId +
                ", recipientAccountId=" + recipientAccountId +
                ", recipientBillId=" + recipientBillId +
                ", amountOfTransfer=" + amountOfTransfer +
                '}';
    }
}