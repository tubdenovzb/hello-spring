package com.javastart.bank.controller;

import com.javastart.bank.controller.dto.PaymentRequestDTO;
import com.javastart.bank.controller.dto.PaymentResponseDTO;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    private Long createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.makePayment(paymentRequestDTO.getAccountId(), paymentRequestDTO.getBillId(),
                paymentRequestDTO.getAmountOfPayment());
    }

    @GetMapping("/payments/{paymentId}")
    private PaymentResponseDTO getPayment(@PathVariable Long paymentId) {
        return new PaymentResponseDTO(paymentService.getPaymentById(paymentId));
    }
}