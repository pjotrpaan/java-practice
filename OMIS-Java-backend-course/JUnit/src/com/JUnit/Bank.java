package com.JUnit;

public class Bank {
    private int balance;
    private BankType bank;

    public Bank(int balance, BankType bank) {
        this.balance = balance;
        this.bank = bank;
    }

    public int getBalance() {
        return balance;
    }

    public BankType getBank() {
        return bank;
    }

    public void withDraw(int money) {
         this.balance-=money;
    }

    public void deposit(int money) {
        this.balance+=money;
    }

    public int maxValue(int a, int b) {
//        return a > b ? a : b;
        return Math.max(a, b);

    }

    @Override
    public String toString() {
        return "Bank{" +
                "balance=" + balance +
                ", bank=" + bank +
                '}';
    }
}
