package com.sabek.bank_account_kata.application.controller;

import java.math.BigDecimal;

public record WithdrawRequest(BigDecimal amount) {}
