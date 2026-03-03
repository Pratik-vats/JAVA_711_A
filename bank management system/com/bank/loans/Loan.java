package com.bank.loans;

public class Loan {

    private double loanAmount;
    private double annualInterestRate;
    private int tenureYears;

    public Loan(double loanAmount, double annualInterestRate, int tenureYears) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.tenureYears = tenureYears;
    }

    public double calculateEMI() {
        double monthlyRate = annualInterestRate / (12 * 100);
        int months = tenureYears * 12;

        double emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);

        return emi;
    }
}