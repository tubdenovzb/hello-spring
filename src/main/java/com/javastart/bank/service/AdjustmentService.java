package com.javastart.bank.service;

import com.javastart.bank.dao.AdjustmentDAO;
import com.javastart.bank.entity.Adjustment;
import com.javastart.bank.exception.AdjustmentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdjustmentService {

    private final AdjustmentDAO adjustmentDAO;

    private final BillService billService;

    public AdjustmentService(AdjustmentDAO adjustmentDAO, BillService billService) {
        this.adjustmentDAO = adjustmentDAO;
        this.billService = billService;
    }

    public Long makeAdjustment(Long accountId, Long billId, Integer amountOfAdjustment) {
        Adjustment adjustment = new Adjustment(accountId, billId, amountOfAdjustment);
        billService.updateBillByAdjustment(accountId, billId, amountOfAdjustment);
        adjustmentDAO.save(adjustment);
        return adjustment.getAdjustmentId();
    }

    public Adjustment getAdjustmentById(Long adjustmentId) {
        Adjustment adjustment = adjustmentDAO.findById(adjustmentId);
        if (adjustment == null) {
            throw new AdjustmentNotFoundException("Can't find adjustment with id: " + adjustmentId);
        }
        return adjustment;
    }
}