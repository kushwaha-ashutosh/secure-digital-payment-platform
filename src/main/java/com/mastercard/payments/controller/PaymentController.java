package com.mastercard.payments.controller;

import com.mastercard.payments.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    // ✅ Dependency Injection
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public String processPayment(
            @RequestParam String fromWallet,
            @RequestParam String toWallet,
            @RequestParam double amount,
            @RequestParam String method,
            @RequestHeader("Idempotency-Key") String idempotencyKey) {

        return paymentService.processPayment(
                fromWallet,
                toWallet,
                amount,
                method,
                idempotencyKey
        );
    }
}
