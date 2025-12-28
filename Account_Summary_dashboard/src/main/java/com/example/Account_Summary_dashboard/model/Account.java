package com.example.Account_Summary_dashboard.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNo;
    private String type;
    private double balance;
    private Long userId;

	}
    
