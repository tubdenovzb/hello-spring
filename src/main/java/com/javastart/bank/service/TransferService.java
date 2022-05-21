package com.javastart.bank.service;

import com.javastart.bank.dao.TransferDAO;
import com.javastart.bank.entity.Transfer;
import com.javastart.bank.exception.TransferNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final TransferDAO transferDAO;

    private final BillService billService;

    public TransferService(TransferDAO transferDAO, BillService billService) {
        this.transferDAO = transferDAO;
        this.billService = billService;
    }

    public Long makeTransfer(Long remitterAccountId, Long remitterBillId,
                             Long recipientAccountId, Long recipientBillId, Integer amountOfTransfer) {
        Transfer transfer = new Transfer(remitterAccountId, remitterBillId,
                recipientAccountId, recipientBillId, amountOfTransfer);
        billService.updateBillByTransferFrom(remitterAccountId, remitterBillId, amountOfTransfer);
        billService.updateBillByTransferTo(recipientAccountId, recipientBillId, amountOfTransfer);
        transferDAO.save(transfer);
        return transfer.getTransferId();
    }

    public Transfer getTransferById(Long transferId) {
        Transfer transfer = transferDAO.findById(transferId);
        if (transfer == null) {
            throw new TransferNotFoundException("Can't find transfer with id: " + transferId);
        }
        return transfer;
    }
}