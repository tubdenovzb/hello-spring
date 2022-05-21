package com.javastart.bank.controller;

import com.javastart.bank.controller.dto.TransferRequestDTO;
import com.javastart.bank.controller.dto.TransferResponseDTO;
import com.javastart.bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfers")
    private Long createTransfer(@RequestBody TransferRequestDTO transferRequestDTO) {
        return transferService.makeTransfer(transferRequestDTO.getRemitterAccountId(),
                transferRequestDTO.getRemitterBillId(), transferRequestDTO.getRecipientAccountId(),
                transferRequestDTO.getRecipientBillId(), transferRequestDTO.getAmountOfTransfer());
    }

    @GetMapping("/transfers/{transferId}")
    private TransferResponseDTO getTransfer(@PathVariable Long transferId) {
        return new TransferResponseDTO(transferService.getTransferById(transferId));
    }
}