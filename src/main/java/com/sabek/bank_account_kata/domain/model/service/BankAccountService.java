package com.sabek.bank_account_kata.domain.model.service;

import com.sabek.bank_account_kata.domain.model.Transaction;
import com.sabek.bank_account_kata.domain.model.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankAccountService {
    private final TransactionRepository transactionRepository;
    private BigDecimal balance = BigDecimal.ZERO;

    public BankAccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit être positif.");
        }
        balance = balance.add(amount);
        Transaction transaction = new Transaction(LocalDateTime.now(), amount, balance);
        transactionRepository.save(transaction);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le montant du retrait doit être positif.");
        }
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Fonds insuffisants.");
        }
        balance = balance.subtract(amount);
        Transaction transaction = new Transaction(LocalDateTime.now(), amount.negate(), balance);
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
