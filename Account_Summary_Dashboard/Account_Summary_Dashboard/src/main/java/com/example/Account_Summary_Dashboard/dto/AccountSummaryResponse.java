package com.example.Account_Summary_Dashboard.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountSummaryResponse {

    private String maskedAccountNumber;
    private String accountType;
    private Double balance;
    private String currency;
    private List<TransactionResponse> recentTransactions;
}

