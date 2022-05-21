package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Transfer;

public class TransferResponseDTO {

    private Long transferId;

    private Long remitterAccountId;

    private Long remitterBillId;

    private Long recipientAccountId;

    private Long recipientBillId;

    private Integer amountOfTransfer;

    public TransferResponseDTO(Long transferId, Long remitterAccountId, Long remitterBillId, Long recipientAccountId, Long recipientBillId, Integer amountOfTransfer) {
        this.transferId = transferId;
        this.remitterAccountId = remitterAccountId;
        this.remitterBillId = remitterBillId;
        this.recipientAccountId = recipientAccountId;
        this.recipientBillId = recipientBillId;
        this.amountOfTransfer = amountOfTransfer;
    }

    public TransferResponseDTO(Transfer transfer) {
        transferId = transfer.getTransferId();
        remitterAccountId = transfer.getRemitterAccountId();
        remitterBillId = transfer.getRemitterBillId();
        recipientAccountId = transfer.getRecipientAccountId();
        recipientBillId = transfer.getRecipientBillId();
        amountOfTransfer = transfer.getAmountOfTransfer();
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
}