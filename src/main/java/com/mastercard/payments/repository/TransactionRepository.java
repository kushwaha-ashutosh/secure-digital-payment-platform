package com.mastercard.payments.repository;

import com.mastercard.payments.model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class TransactionRepository {

    private final Map<String, Transaction> transactionStore = new HashMap<>();

    public Transaction save(Transaction transaction) {
        transactionStore.put(transaction.getTransactionId(), transaction);
        return transaction;
    }

    public Transaction findById(String transactionId) {
        return transactionStore.get(transactionId);
    }
}
