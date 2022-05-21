package com.javastart.bank.controller.dto;

import com.javastart.bank.entity.Adjustment;

public class AdjustmentResponseDTO {

    private Long adjustmentId;

    private Long accountId;

    private Long billId;

    private Integer amountOfAdjustment;

    public AdjustmentResponseDTO(Long adjustmentId, Long accountId, Long billId, Integer amountOfAdjustment) {
        this.adjustmentId = adjustmentId;
        this.accountId = accountId;
        this.billId = billId;
        this.amountOfAdjustment = amountOfAdjustment;
    }

    public AdjustmentResponseDTO(Adjustment adjustment) {
        adjustmentId = adjustment.getAdjustmentId();
        accountId = adjustment.getAccountId();
        billId = adjustment.getBillId();
        amountOfAdjustment = adjustment.getAmountOfAdjustment();
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
}
