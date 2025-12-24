package com.mastercard.payments.validation;

import java.util.List;

public class ValidationChain {

    private final List<ValidationStep> steps;

    public ValidationChain(List<ValidationStep> steps) {
        this.steps = steps;
    }

    public void validate(String fromWallet,
                         String toWallet,
                         double amount) {

        for (ValidationStep step : steps) {
            step.validate(fromWallet, toWallet, amount);
        }
    }
}
