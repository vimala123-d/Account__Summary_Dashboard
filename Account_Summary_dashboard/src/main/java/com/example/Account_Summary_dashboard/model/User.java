package com.example.Account_Summary_dashboard.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Entity
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}