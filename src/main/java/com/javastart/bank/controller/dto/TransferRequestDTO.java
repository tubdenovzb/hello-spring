package com.javastart.bank.controller.dto;

public class TransferRequestDTO {

    private Long remitterAccountId;

    private Long remitterBillId;

    private Long recipientAccountId;

    private Long recipientBillId;

    private Integer amountOfTransfer;

    public TransferRequestDTO(Long remitterAccountId, Long remitterBillId, Long recipientAccountId, Long recipientBillId, Integer amountOfTransfer) {
        this.remitterAccountId = remitterAccountId;
        this.remitterBillId = remitterBillId;
        this.recipientAccountId = recipientAccountId;
        this.recipientBillId = recipientBillId;
        this.amountOfTransfer = amountOfTransfer;
    }

    public TransferRequestDTO() {
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
}