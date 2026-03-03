package com.bank.customers;

import com.bank.accounts.Account;

public class Customer {

    private String customerId;
    private String name;
    private Account account;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void linkAccount(Account account) {
        this.account = account;
        System.out.println("Account linked to customer " + name);
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}