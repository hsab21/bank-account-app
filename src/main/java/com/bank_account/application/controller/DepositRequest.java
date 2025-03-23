package com.bank_account.application.controller;

import java.math.BigDecimal;

public record DepositRequest(BigDecimal amount) {}
