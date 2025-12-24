package com.mastercard.payments.controller;

import com.mastercard.payments.metrics.MetricsCollector;
import com.mastercard.payments.metrics.PaymentMetrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {

    @GetMapping("/metrics/summary")
    public PaymentMetrics getMetrics() {
        return MetricsCollector.getMetrics();
    }
}
