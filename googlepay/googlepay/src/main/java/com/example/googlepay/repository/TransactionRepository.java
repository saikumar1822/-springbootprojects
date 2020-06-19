package com.example.googlepay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.googlepay.model.Transaction;
import com.example.googlepay.model.User;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	

		 List<Transaction> findTransactionByUser(User user);

}
