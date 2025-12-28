package com.example.Account_Summary_Dashboard.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserDashboardResponse {

    private Long userId;
    private String fullName;
    private String email;
    private List<AccountSummaryResponse> accounts;
}

