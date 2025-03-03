package se.lexicon.model;

import se.lexicon.exception.InsufficientFundsException;

public class BankAccount {
    private static int nextAccountNumber = 1000; // Starting account number
    private final int accountNumber;
    private double balance;

    public BankAccount() {
        this.accountNumber = nextAccountNumber++;
    }



    public void deposit(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }

        balance += amount;

    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        if (amount > balance ){
            throw new InsufficientFundsException("Insufficient Funds!", balance, amount);
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
