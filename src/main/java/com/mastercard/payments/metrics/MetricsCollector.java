package com.mastercard.payments.metrics;

public class MetricsCollector {

    private static final PaymentMetrics metrics = new PaymentMetrics();

    private MetricsCollector() {}

    public static PaymentMetrics getMetrics() {
        return metrics;
    }
}
