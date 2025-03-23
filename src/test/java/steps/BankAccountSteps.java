package steps;

import com.bank_account.domain.model.BankAccount;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class BankAccountSteps {

    private BankAccount bankAccount;
    private Exception capturedException; // Pour stocker l'exception levée

    @Given("un compte avec un solde de {int} euros")
    public void un_compte_avec_un_solde(Integer  soldeInitial) {
        bankAccount = new BankAccount(BigDecimal.valueOf(soldeInitial));
    }

    @When("je dépose {int} euros")
    public void je_depose(Integer montant) {
        bankAccount.deposit(BigDecimal.valueOf(montant));
    }

    @When("je retire {int} euros")
    public void je_retire(Integer montant) {
        try {
            bankAccount.withdraw(BigDecimal.valueOf(montant));
        } catch (Exception e) {
            capturedException = e;  // Capture de l'exception
        }
    }

    @Then("le solde du compte doit être de {int} euros")
    public void le_solde_du_compte_doit_etre(Integer soldeAttendu) {
        Assertions.assertEquals(BigDecimal.valueOf(soldeAttendu), bankAccount.getBalance());
    }

    @Then("une erreur est levée avec le message {string}")
    public void une_erreur_est_levee(String messageAttendu) {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(new BigDecimal(1000)); // Montant élevé pour générer l'erreur
        });
        Assertions.assertEquals(messageAttendu, exception.getMessage());
    }
}
