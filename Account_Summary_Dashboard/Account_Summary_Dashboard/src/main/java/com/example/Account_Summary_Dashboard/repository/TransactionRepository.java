package com.example.Account_Summary_Dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Account_Summary_Dashboard.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findTop5ByAccount_AccountIdOrderByTransactionDateDesc(Long accountId);
}
