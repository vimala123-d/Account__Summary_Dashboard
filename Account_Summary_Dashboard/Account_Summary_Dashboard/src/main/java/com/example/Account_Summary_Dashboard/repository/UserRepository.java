package com.example.Account_Summary_Dashboard.repository;

import com.example.Account_Summary_Dashboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
