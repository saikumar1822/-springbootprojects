package com.example.BankingApplication1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankingApplication1.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
