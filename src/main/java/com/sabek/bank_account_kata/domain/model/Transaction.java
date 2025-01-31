package com.sabek.bank_account_kata.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance;

    protected Transaction() {}

    public Transaction(LocalDateTime date, BigDecimal amount, BigDecimal balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Long getId() { return id; }
    public LocalDateTime getDate() { return date; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getBalance() { return balance; }
}
