package com.example.Account_Summary_Dashboard.controller;

import com.example.Account_Summary_Dashboard.dto.UserDashboardResponse;
import com.example.Account_Summary_Dashboard.service.AccountSummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final AccountSummaryService accountSummaryService;

    public DashboardController(AccountSummaryService accountSummaryService) {
        this.accountSummaryService = accountSummaryService;
    }

    @GetMapping("/summary")
    public ResponseEntity<UserDashboardResponse> getDashboard(
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                accountSummaryService.getDashboard(userId)
        );
    }
}
