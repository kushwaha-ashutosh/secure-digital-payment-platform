package com.mastercard.payments.validation;

public class AmountValidation implements ValidationStep {

    @Override
    public void validate(String fromWallet,
                         String toWallet,
                         double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
    }
}
