package com.bank_account.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private BigDecimal balance;
    private List<Transaction> transactions;

    public BankAccount() {
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
    }
    public BankAccount(BigDecimal balance){
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
    public void deposit(BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit être positif.");
        }
        balance = balance.add(amount);
        transactions.add(new Transaction(java.time.LocalDateTime.now(), amount, balance));
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Fonds insuffisants.");
        }
        balance = balance.subtract(amount);
        transactions.add(new Transaction(java.time.LocalDateTime.now(), amount.negate(), balance));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
