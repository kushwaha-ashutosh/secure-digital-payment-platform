package com.mastercard.payments.engine;

import com.mastercard.payments.service.WalletService;

public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;

    public WalletPaymentStrategy(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public void processPayment(String fromWallet,
                               String toWallet,
                               double amount) {

        // Debit sender
        walletService.debit(fromWallet, amount);

        // Credit receiver
        walletService.addBalance(toWallet, amount);
    }
}
