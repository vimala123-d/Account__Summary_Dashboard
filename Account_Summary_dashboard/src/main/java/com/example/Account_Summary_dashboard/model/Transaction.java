package com.example.Account_Summary_dashboard.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNo;
    private double amount;
    private String type; // DEBIT/CREDIT
    private LocalDate date;
}
