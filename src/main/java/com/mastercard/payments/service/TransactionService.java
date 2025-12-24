package com.mastercard.payments.service;

import com.mastercard.payments.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {

    // In-memory transaction store
    private final Map<String, Transaction> transactionStore = new HashMap<>();

    public Transaction createTransaction(String from, String to, double amount) {
        Transaction transaction = new Transaction(from, to, amount);
        transactionStore.put(transaction.getTransactionId(), transaction);
        return transaction;
    }

    public Transaction getTransaction(String transactionId) {
        Transaction transaction = transactionStore.get(transactionId);
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction not found");
        }
        return transaction;
    }

    public void markSuccess(Transaction transaction) {
        transaction.markSuccess();
    }

    public void markFailed(Transaction transaction, String reason) {
        transaction.markFailed(reason);
    }
}
