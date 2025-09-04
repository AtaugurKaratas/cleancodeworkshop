package com.workshop.bankkata;

import java.util.*;

public class Account {
    private int balance = 0;
    private final List<String> transactions = new ArrayList<>();

    public void deposit(int amount) {
        balance += amount;
        transactions.add("Deposit " + amount + " | Balance: " + balance);
    }

    public void withdraw(int amount) {
        balance -= amount;
        transactions.add("Withdraw " + amount + " | Balance: " + balance);
    }

    public void printStatement() {
        System.out.println("DATE | OPERATION | AMOUNT | BALANCE");
        for (String t : transactions) {
            System.out.println(t);
        }
    }

    // quick hack to support CSV export
    public void printCsvStatement() {
        System.out.println("date,operation,amount,balance");
        for (String t : transactions) {
            System.out.println(t.replace(" | ", ","));
        }
    }
}
