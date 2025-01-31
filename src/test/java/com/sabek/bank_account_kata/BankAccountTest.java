package com.sabek.bank_account_kata;

import com.sabek.bank_account_kata.domain.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    void shouldDepositMoney() {
        bankAccount.deposit(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), bankAccount.getBalance());
    }

    @Test
    void shouldWithdrawMoney() {
        bankAccount.deposit(BigDecimal.valueOf(200));
        bankAccount.withdraw(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(150), bankAccount.getBalance());
    }

    @Test
    void shouldNotWithdrawMoreThanBalance() {
        bankAccount.deposit(BigDecimal.valueOf(50));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(BigDecimal.valueOf(100));
        });
        assertEquals("Fonds insuffisants.", exception.getMessage());
    }

    @Test
    void shouldNotAllowNegativeDeposit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(BigDecimal.valueOf(-10));
        });
        assertEquals("Le montant du dépôt doit être positif.", exception.getMessage());
    }

    @Test
    void deposit_shouldThrowException_whenAmountIsNegative() {
        // GIVEN
        BankAccount account = new BankAccount();

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> account.deposit(BigDecimal.valueOf(-100)));
    }

    @Test
    void withdraw_shouldThrowException_whenBalanceIsInsufficient() {
        // GIVEN
        BankAccount account = new BankAccount();

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(100)));
    }
}
