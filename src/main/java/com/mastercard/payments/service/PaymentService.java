package com.mastercard.payments.service;

import com.mastercard.payments.engine.PaymentFactory;
import com.mastercard.payments.engine.PaymentStrategy;
import com.mastercard.payments.metrics.MetricsCollector;
import com.mastercard.payments.metrics.PaymentMetrics;
import com.mastercard.payments.model.Transaction;
import com.mastercard.payments.security.IdempotencyStore;
import com.mastercard.payments.validation.AmountValidation;
import com.mastercard.payments.validation.BalanceValidation;
import com.mastercard.payments.validation.ValidationChain;
import com.mastercard.payments.validation.WalletStatusValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final WalletService walletService;
    private final TransactionService transactionService;
    private final IdempotencyStore idempotencyStore;

    // ✅ All dependencies injected by Spring
    public PaymentService(WalletService walletService,
                          TransactionService transactionService,
                          IdempotencyStore idempotencyStore) {
        this.walletService = walletService;
        this.transactionService = transactionService;
        this.idempotencyStore = idempotencyStore;
    }

    public String processPayment(String fromWallet,
                                 String toWallet,
                                 double amount,
                                 String method,
                                 String idempotencyKey) {

        if (idempotencyStore.isProcessed(idempotencyKey)) {
            return idempotencyStore.getTransactionId(idempotencyKey);
        }

        Transaction transaction =
                transactionService.createTransaction(fromWallet, toWallet, amount);

        PaymentMetrics metrics = MetricsCollector.getMetrics();

        try {
            ValidationChain validationChain = new ValidationChain(
                    List.of(
                            new AmountValidation(),
                            new WalletStatusValidation(walletService),
                            new BalanceValidation(walletService)
                    )
            );

            validationChain.validate(fromWallet, toWallet, amount);

            PaymentStrategy strategy =
                    PaymentFactory.getPaymentStrategy(method, walletService);

            strategy.processPayment(fromWallet, toWallet, amount);

            transactionService.markSuccess(transaction);
            metrics.recordSuccess(amount);

            idempotencyStore.markProcessed(
                    idempotencyKey,
                    transaction.getTransactionId()
            );

            return transaction.getTransactionId();

        } catch (Exception ex) {
            transactionService.markFailed(transaction, ex.getMessage());
            metrics.recordFailure();
            throw ex;
        }
    }
}
