package com.mastercard.payments.metrics;

public class PaymentMetrics {

    private int totalTransactions;
    private int successfulTransactions;
    private int failedTransactions;
    private double totalAmountProcessed;

    public synchronized void recordSuccess(double amount) {
        totalTransactions++;
        successfulTransactions++;
        totalAmountProcessed += amount;
    }

    public synchronized void recordFailure() {
        totalTransactions++;
        failedTransactions++;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public int getSuccessfulTransactions() {
        return successfulTransactions;
    }

    public int getFailedTransactions() {
        return failedTransactions;
    }

    public double getTotalAmountProcessed() {
        return totalAmountProcessed;
    }
}
