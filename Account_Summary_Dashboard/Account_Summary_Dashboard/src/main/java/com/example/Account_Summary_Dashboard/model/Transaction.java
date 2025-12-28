package com.example.Account_Summary_Dashboard.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private String transactionType; // CREDIT / DEBIT
    private Double amount;
    private LocalDateTime transactionDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}

