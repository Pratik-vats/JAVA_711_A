package com.bank;

import com.bank.accounts.SavingsAccount;
import com.bank.customers.Customer;
import com.bank.loans.Loan;
import static com.bank.util.BankUtil.generateAccountNumber;
import static com.bank.util.BankUtil.validateMinimumBalance;

public class BankApplication {

    public static void main(String[] args) {

        String accNo = generateAccountNumber();

        if (!validateMinimumBalance(5000)) {
            System.out.println("Minimum balance not satisfied!");
            return;
        }

        SavingsAccount savings = new SavingsAccount(accNo, 5000, 5);

        Customer customer = new Customer("C101", "Pratik");

        customer.linkAccount(savings);

        savings.deposit(2000);

        savings.withdraw(1000);

        double interest = savings.calculateInterest();
        System.out.println("Interest Earned: " + interest);

        Loan loan = new Loan(100000, 10, 2);
        System.out.println("Monthly EMI: " + loan.calculateEMI());
    }
}

