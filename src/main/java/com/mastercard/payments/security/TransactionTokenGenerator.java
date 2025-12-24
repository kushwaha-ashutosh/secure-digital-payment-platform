package com.mastercard.payments.security;

import java.util.UUID;

public class TransactionTokenGenerator {

    public static String generateToken() {
        return UUID.randomUUID().toString();
    }
}
