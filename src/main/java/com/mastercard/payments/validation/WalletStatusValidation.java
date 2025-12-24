package com.mastercard.payments.validation;

import com.mastercard.payments.service.WalletService;

public class WalletStatusValidation implements ValidationStep {

    private final WalletService walletService;

    public WalletStatusValidation(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public void validate(String fromWallet,
                         String toWallet,
                         double amount) {

        walletService.getWallet(fromWallet);
        walletService.getWallet(toWallet);
    }
}
