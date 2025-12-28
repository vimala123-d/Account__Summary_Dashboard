package com.example.Account_Summary_dashboard.repository;

import com.example.Account_Summary_dashboard.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountNo(String accountNo);
}