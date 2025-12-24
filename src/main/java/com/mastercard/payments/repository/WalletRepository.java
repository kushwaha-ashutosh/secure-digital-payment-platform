package com.mastercard.payments.repository;

import com.mastercard.payments.model.Wallet;

import java.util.HashMap;
import java.util.Map;

public class WalletRepository {

    private final Map<String, Wallet> walletStore = new HashMap<>();

    public Wallet save(Wallet wallet) {
        walletStore.put(wallet.getWalletId(), wallet);
        return wallet;
    }

    public Wallet findById(String walletId) {
        return walletStore.get(walletId);
    }

    public boolean exists(String walletId) {
        return walletStore.containsKey(walletId);
    }
}
