package com.mastercard.payments.validation;

public interface ValidationStep {
    void validate(String fromWallet,
                  String toWallet,
                  double amount);
}
