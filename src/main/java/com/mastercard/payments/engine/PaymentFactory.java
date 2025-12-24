package com.mastercard.payments.engine;

import com.mastercard.payments.service.WalletService;

public class PaymentFactory {

    public static PaymentStrategy getPaymentStrategy(String method,
                                                     WalletService walletService) {

        if ("WALLET".equalsIgnoreCase(method)) {
            return new WalletPaymentStrategy(walletService);
        }

        if ("CARD".equalsIgnoreCase(method)) {
            return new CardPaymentStrategy();
        }

        throw new IllegalArgumentException("Unsupported payment method");
    }
}
