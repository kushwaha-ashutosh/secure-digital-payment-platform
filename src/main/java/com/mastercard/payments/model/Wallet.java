package com.mastercard.payments.model;

import java.util.UUID;

public class Wallet {

    private final String walletId;
    private double balance;
    private boolean active;

    public Wallet() {
        this.walletId = UUID.randomUUID().toString();
        this.balance = 0.0;
        this.active = true;
    }

    // Getters
    public String getWalletId() {
        return walletId;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    // Business methods
    public void addBalance(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
    }

    public void debit(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
        } else {
            throw new IllegalStateException("Insufficient balance");
        }
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }
}
