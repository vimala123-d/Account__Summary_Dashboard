package com.example.Account_Summary_dashboard.dto;

import com.example.Account_Summary_dashboard.model.Account;
import com.example.Account_Summary_dashboard.model.Transaction;
import com.example.Account_Summary_dashboard.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class AccountSummaryResponse {
    private User user;
    private List<Account> accounts;
    private List<Transaction> transactions;
    //private List<Card> cards;
}
