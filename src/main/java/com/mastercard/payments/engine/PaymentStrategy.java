package com.mastercard.payments.engine;

public interface PaymentStrategy {

    void processPayment(String fromWallet,
                        String toWallet,
                        double amount);
}
