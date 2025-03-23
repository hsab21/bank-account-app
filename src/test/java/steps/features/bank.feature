Feature: Gestion de compte bancaire
  Scenario: Dépôt d'argent
    Given un compte avec un solde de 100 euros
    When je dépose 50 euros
    Then le solde du compte doit être de 150 euros

  Scenario: Retrait d'argent avec fonds suffisants
    Given un compte avec un solde de 200 euros
    When je retire 50 euros
    Then le solde du compte doit être de 150 euros

  Scenario: Retrait d'argent avec fonds insuffisants
    Given un compte avec un solde de 100 euros
    When je retire 200 euros
    Then une erreur est levée avec le message "Fonds insuffisants."
