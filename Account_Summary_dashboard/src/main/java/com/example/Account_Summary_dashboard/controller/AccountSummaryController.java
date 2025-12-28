package com.example.Account_Summary_dashboard.controller;

import com.example.Account_Summary_dashboard.dto.AccountSummaryResponse;
import com.example.Account_Summary_dashboard.service.AccountSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account-summary")
@RequiredArgsConstructor
public class AccountSummaryController {
    
    private final AccountSummaryService service;


    @GetMapping("/{userId}")
    public AccountSummaryResponse getSummary(@PathVariable Long userId) {
        return service.getAccountSummary(userId);
    }
}
