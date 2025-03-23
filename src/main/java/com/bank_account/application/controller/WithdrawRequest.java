package com.bank_account.application.controller;

import java.math.BigDecimal;

public record WithdrawRequest(BigDecimal amount) {}
