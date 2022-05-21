package com.javastart.bank.service;

import com.javastart.bank.dao.BillDAO;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.exception.BillNotFoundException;
import com.javastart.bank.exception.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private final BillDAO billDAO;
    private final AccountService accountService;

    @Autowired
    public BillService(BillDAO billDAO, AccountService accountService) {
        this.billDAO = billDAO;
        this.accountService = accountService;
    }

    public Long createBill(Long accountId, Integer amount) {
        Bill bill = new Bill(accountId, amount);
        billDAO.save(bill);
        accountService.addBillToAccount(accountId, bill);
        return bill.getBillId();
    }

    public Bill getBillById(Long billId) {
        Bill bill = billDAO.findById(billId);
        if (bill == null) {
            throw new BillNotFoundException("Can't find bill with id: " + billId);
        }
        return bill;
    }

    public void updateBillByPayment(Long accountId, Long billId, Integer amountOfPayment) {
        accountService.getAccountById(accountId);
        Bill bill = getBillById(billId);
        if (bill.getAmount() < amountOfPayment) {
            throw new InsufficientFundsException("Insufficient funds for payment");
        }
        billDAO.payment(billId, amountOfPayment);
    }

    public void updateBillByAdjustment(Long accountId, Long billId, Integer amountOfAdjustment) {
        accountService.getAccountById(accountId);
        Bill bill = getBillById(billId);
        billDAO.adjustment(billId,amountOfAdjustment);
    }

    public void updateBillByTransferFrom(Long remitterAccountId, Long remitterBillId, Integer amountOfTransfer) {
        accountService.getAccountById(remitterAccountId);
        Bill remitterBill = getBillById(remitterBillId);
        if (remitterBill.getAmount() < amountOfTransfer) {
            throw new InsufficientFundsException("Insufficient funds for transfer");
        }
        billDAO.payment(remitterBillId, amountOfTransfer);
    }

    public void updateBillByTransferTo(Long recipientAccountId, Long recipientBillId, Integer amountOfTransfer) {
        accountService.getAccountById(recipientAccountId);
        Bill recipientBill = getBillById(recipientBillId);
        billDAO.adjustment(recipientBillId, amountOfTransfer);
    }
}