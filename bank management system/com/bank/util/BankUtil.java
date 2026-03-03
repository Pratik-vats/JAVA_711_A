package com.bank.util;

import java.util.UUID;

public class BankUtil {

    public static String generateAccountNumber() {
        return "ACC" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static boolean validateMinimumBalance(double balance) {
        return balance >= 1000;
    }
}