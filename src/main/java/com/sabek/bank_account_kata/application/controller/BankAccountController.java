package com.sabek.bank_account_kata.application.controller;


import com.sabek.bank_account_kata.domain.model.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
@Tag(name = "Bank Account API", description = "Gère les opérations bancaires")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/deposit")
    @Operation(summary = "Effectuer un dépôt")
    public String deposit(@RequestBody DepositRequest request) {
        bankAccountService.deposit(request.amount());
        return "Dépôt réussi : " + request.amount();
    }

    @PostMapping("/withdraw")
    @Operation(summary = "Effectuer un retrait")
    public String withdraw(@RequestBody WithdrawRequest request) {
        bankAccountService.withdraw(request.amount());
        return "Retrait réussi : " + request.amount();
    }

    @GetMapping("/statement")
    @Operation(summary = "Afficher l'historique des transactions")
    public String getStatement() {
        return bankAccountService.getTransactions().toString();
    }
}
