package com.example.Account_Summary_Dashboard.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionResponse {

    private String transactionType;
    private Double amount;
    private LocalDateTime transactionDate;
    private String description;
}
