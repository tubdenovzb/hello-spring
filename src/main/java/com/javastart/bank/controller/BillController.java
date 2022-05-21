package com.javastart.bank.controller;

import com.javastart.bank.controller.dto.BillRequestDTO;
import com.javastart.bank.controller.dto.BillResponseDTO;
import com.javastart.bank.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/bills")
    private Long createBill(@RequestBody BillRequestDTO billRequestDTO) {
        return billService.createBill(billRequestDTO.getAccountId(), billRequestDTO.getAmount());
    }

    @GetMapping("bills/{billId}")
    private BillResponseDTO getBill(@PathVariable Long billId) {
        return new BillResponseDTO(billService.getBillById(billId));
    }
}