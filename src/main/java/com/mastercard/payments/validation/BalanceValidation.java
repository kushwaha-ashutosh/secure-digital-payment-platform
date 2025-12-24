package com.mastercard.payments.validation;

import com.mastercard.payments.model.Wallet;
import com.mastercard.payments.service.WalletService;

public class BalanceValidation implements ValidationStep {

    private final WalletService walletService;

    public BalanceValidation(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public void validate(String fromWallet,
                         String toWallet,
                         double amount) {

        Wallet wallet = walletService.getWallet(fromWallet);

        if (wallet.getBalance() < amount) {
            throw new IllegalStateException("Insufficient balance");
        }
    }
}
