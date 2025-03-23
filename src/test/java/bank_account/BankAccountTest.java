package bank_account;

import com.bank_account.domain.model.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;


class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    void shouldDepositMoney() {
        bankAccount.deposit(BigDecimal.valueOf(100));
        Assertions.assertEquals(BigDecimal.valueOf(100), bankAccount.getBalance());
    }

    @Test
    void shouldWithdrawMoney() {
        bankAccount.deposit(BigDecimal.valueOf(200));
        bankAccount.withdraw(BigDecimal.valueOf(50));
        Assertions.assertEquals(BigDecimal.valueOf(150), bankAccount.getBalance());
    }

    @Test
    void shouldNotWithdrawMoreThanBalance() {
        bankAccount.deposit(BigDecimal.valueOf(50));
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(BigDecimal.valueOf(100));
        });
        Assertions.assertEquals("Fonds insuffisants.", exception.getMessage());
    }

    @Test
    void shouldNotAllowNegativeDeposit() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(BigDecimal.valueOf(-10));
        });
        Assertions.assertEquals("Le montant du dépôt doit être positif.", exception.getMessage());
    }

    @Test
    void deposit_shouldThrowException_whenAmountIsNegative() {
        // GIVEN
        BankAccount account = new BankAccount();

        // WHEN & THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.deposit(BigDecimal.valueOf(-100)));
    }

    @Test
    void withdraw_shouldThrowException_whenBalanceIsInsufficient() {
        // GIVEN
        BankAccount account = new BankAccount();

        // WHEN & THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(100)));
    }
}
