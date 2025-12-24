package com.mastercard.payments.engine;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void processPayment(String fromWallet,
                               String toWallet,
                               double amount) {

        // Simulate card authorization
        System.out.println("Authorizing card payment...");

        if (amount > 100000) {
            throw new IllegalStateException("Card limit exceeded");
        }

        System.out.println("Card payment successful");
    }
}
