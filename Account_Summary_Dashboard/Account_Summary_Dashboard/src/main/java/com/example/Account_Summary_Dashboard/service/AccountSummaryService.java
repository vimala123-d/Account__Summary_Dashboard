package com.example.Account_Summary_Dashboard.service;


import com.example.Account_Summary_Dashboard.dto.AccountSummaryResponse;
import com.example.Account_Summary_Dashboard.dto.TransactionResponse;
import com.example.Account_Summary_Dashboard.dto.UserDashboardResponse;
import com.example.Account_Summary_Dashboard.model.Account;
import com.example.Account_Summary_Dashboard.model.User;
import com.example.Account_Summary_Dashboard.model.Transaction;
import com.example.Account_Summary_Dashboard.repository.AccountRepository;
import com.example.Account_Summary_Dashboard.repository.TransactionRepository;
import com.example.Account_Summary_Dashboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountSummaryService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountSummaryService(UserRepository userRepository,
                                 AccountRepository accountRepository,
                                 TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public UserDashboardResponse getDashboard(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Account> accounts = accountRepository.findByUser_UserId(userId);

        List<AccountSummaryResponse> accountResponses = accounts.stream().map(account -> {

            List<Transaction> transactions =
                    transactionRepository.findTop5ByAccount_AccountIdOrderByTransactionDateDesc(
                            account.getAccountId()
                    );

            List<TransactionResponse> txResponses = transactions.stream().map(tx -> {
                TransactionResponse tr = new TransactionResponse();
                tr.setTransactionType(tx.getTransactionType());
                tr.setAmount(tx.getAmount());
                tr.setTransactionDate(tx.getTransactionDate());
                tr.setDescription(tx.getDescription());
                return tr;
            }).collect(Collectors.toList());

            AccountSummaryResponse accRes = new AccountSummaryResponse();
            accRes.setMaskedAccountNumber(maskAccount(account.getAccountNumber()));
            accRes.setAccountType(account.getAccountType());
            accRes.setBalance(account.getBalance());
            accRes.setCurrency(account.getCurrency());
            accRes.setRecentTransactions(txResponses);

            return accRes;

        }).collect(Collectors.toList());

        UserDashboardResponse response = new UserDashboardResponse();
        response.setUserId(user.getUserId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setAccounts(accountResponses);

        return response;
    }

    private String maskAccount(String accountNumber) {
        return "XXXXXX" + accountNumber.substring(accountNumber.length() - 4);
    }
}
