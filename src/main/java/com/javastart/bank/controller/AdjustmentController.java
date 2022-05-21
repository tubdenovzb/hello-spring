package com.javastart.bank.controller;

import com.javastart.bank.controller.dto.AdjustmentRequestDTO;
import com.javastart.bank.controller.dto.AdjustmentResponseDTO;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.service.AdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdjustmentController {

    private final AdjustmentService adjustmentService;

    @Autowired
    public AdjustmentController(AdjustmentService adjustmentService) {
        this.adjustmentService = adjustmentService;
    }

    @PostMapping("/adjustments")
    private Long createAdjustment(@RequestBody AdjustmentRequestDTO adjustmentRequestDTO) {
        return adjustmentService.makeAdjustment(adjustmentRequestDTO.getAccountId(),
                adjustmentRequestDTO.getBillId(), adjustmentRequestDTO.getAmountOfAdjustment());
    }

    @GetMapping("/adjustments/{adjustmentId}")
    private AdjustmentResponseDTO getAdjustment(@PathVariable Long adjustmentId) {
        return new AdjustmentResponseDTO(adjustmentService.getAdjustmentById(adjustmentId));
    }
}