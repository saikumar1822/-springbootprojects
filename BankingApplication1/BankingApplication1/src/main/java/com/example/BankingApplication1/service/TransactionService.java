package com.example.BankingApplication1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingApplication1.model.Transaction;
import com.example.BankingApplication1.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	
	public void savetransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		
	}

}
