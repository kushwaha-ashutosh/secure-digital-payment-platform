package com.mastercard.payments.service;

import com.mastercard.payments.model.Wallet;
import com.mastercard.payments.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository = new WalletRepository();

    public Wallet createWallet() {
        Wallet wallet = new Wallet();
        walletRepository.save(wallet);
        return wallet;
    }

    public Wallet getWallet(String walletId) {
        Wallet wallet = walletRepository.findById(walletId);
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet not found");
        }
        return wallet;
    }

    public void addBalance(String walletId, double amount) {
        Wallet wallet = getWallet(walletId);
        wallet.addBalance(amount);
    }

    public void debit(String walletId, double amount) {
        Wallet wallet = getWallet(walletId);
        wallet.debit(amount);
    }
}
