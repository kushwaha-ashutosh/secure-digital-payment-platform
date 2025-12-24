package com.mastercard.payments.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private final String transactionId;
    private final String fromWallet;
    private final String toWallet;
    private final double amount;
    private String status;
    private String failureReason;
    private final LocalDateTime createdAt;

    public Transaction(String fromWallet, String toWallet, double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.amount = amount;
        this.status = "INITIATED";
        this.createdAt = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void markValidated() {
        this.status = "VALIDATED";
    }

    public void markProcessing() {
        this.status = "PROCESSING";
    }

    public void markSuccess() {
        this.status = "SUCCESS";
    }

    public void markFailed(String reason) {
        this.status = "FAILED";
        this.failureReason = reason;
    }
}
