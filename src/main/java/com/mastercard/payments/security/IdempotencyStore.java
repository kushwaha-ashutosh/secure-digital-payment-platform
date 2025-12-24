package com.mastercard.payments.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IdempotencyStore {

    private final Map<String, String> store = new HashMap<>();

    public boolean isProcessed(String key) {
        return store.containsKey(key);
    }

    public String getTransactionId(String key) {
        return store.get(key);
    }

    public void markProcessed(String key, String transactionId) {
        store.put(key, transactionId);
    }
}
