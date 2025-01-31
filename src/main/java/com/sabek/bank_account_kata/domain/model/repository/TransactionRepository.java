package com.sabek.bank_account_kata.domain.model.repository;


import com.sabek.bank_account_kata.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
