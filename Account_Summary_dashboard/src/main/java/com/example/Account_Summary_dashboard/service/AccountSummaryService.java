package com.example.Account_Summary_dashboard.service;


import com.example.Account_Summary_dashboard.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.Account_Summary_dashboard.dto.AccountSummaryResponse;
import com.example.Account_Summary_dashboard.model.Account;
import com.example.Account_Summary_dashboard.model.Transaction;
import com.example.Account_Summary_dashboard.repository.AccountRepository;
import com.example.Account_Summary_dashboard.repository.TransactionRepository;
import com.example.Account_Summary_dashboard.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountSummaryService {

    private final UserRepository userRepository ;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    //private final CardRepository cardRepository;
    

    public AccountSummaryResponse getAccountSummary(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Account> accounts = accountRepository.findByUserId(userId);
        //List<Card> cards = cardRepository.findByUserId(userId);

        List<Transaction> transactions = new ArrayList<>();
        for (Account account : accounts) {
            transactions.addAll(transactionRepository.findByAccountNo(account.getAccountNo()));
        }

        AccountSummaryResponse response = new AccountSummaryResponse();
       response.setAccounts(accounts);
       response.setTransactions(transactions);
       response.setUser(user);


        return response;
    }

}
