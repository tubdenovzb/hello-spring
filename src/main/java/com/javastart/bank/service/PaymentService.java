package com.javastart.bank.service;

import com.javastart.bank.dao.PaymentDAO;
import com.javastart.bank.entity.Payment;
import com.javastart.bank.exception.PaymentNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentDAO paymentDAO;

    private final BillService billService;

    public PaymentService(PaymentDAO paymentDAO, BillService billService) {
        this.paymentDAO = paymentDAO;
        this.billService = billService;
    }

    public Long makePayment(Long accountId, Long billId, Integer amountOfPayment) {
        Payment payment = new Payment(accountId, billId, amountOfPayment);
        billService.updateBillByPayment(accountId, billId, amountOfPayment);
        paymentDAO.save(payment);
        return payment.getPaymentId();
    }

    public Payment getPaymentById(Long paymentId) {
        Payment payment = paymentDAO.findById(paymentId);
        if (payment == null) {
            throw new PaymentNotFoundException("Can't find payment with id: " + paymentId);
        }
        return payment;
    }
}