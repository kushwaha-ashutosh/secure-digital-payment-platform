package com.mastercard.payments.controller;

import com.mastercard.payments.model.Wallet;
import com.mastercard.payments.service.WalletService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;

    // ✅ Dependency Injection via constructor
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/create")
    public Wallet createWallet() {
        return walletService.createWallet();
    }

    @PostMapping("/add-balance")
    public String addBalance(
            @RequestParam String walletId,
            @RequestParam double amount) {

        walletService.addBalance(walletId, amount);
        return "Balance added successfully";
    }
}
