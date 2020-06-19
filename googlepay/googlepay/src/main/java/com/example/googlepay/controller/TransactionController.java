package com.example.googlepay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.googlepay.dto.ResponseDto;
import com.example.googlepay.dto.TransferDto;
import com.example.googlepay.exception.AmountNotFoundException;
import com.example.googlepay.exception.InsufficientBalance;
import com.example.googlepay.exception.PhoneNumberNotFoundException;
import com.example.googlepay.model.Transaction;
import com.example.googlepay.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	
	@PostMapping("/transfer")
	public ResponseEntity<ResponseDto> paymentProcessing(@RequestBody TransferDto transferDto) throws PhoneNumberNotFoundException, AmountNotFoundException, InsufficientBalance {
		logger.info("transaction controller--------------------");
		ResponseDto ticketResponseDto=new ResponseDto();
		transactionService.payment(transferDto);
		ticketResponseDto.setMessage("amount transfered successfully");
		ticketResponseDto.getMessage();
		return new ResponseEntity<ResponseDto>(ticketResponseDto, HttpStatus.OK);	
	}
	
	@GetMapping("/transactions")
	 public ResponseEntity<List<Transaction>> findTransactions(@RequestParam String phoneNo){

	 List<Transaction> transaction;

	 transaction=transactionService.getTransactions(phoneNo);

	 return new ResponseEntity<>(transaction,HttpStatus.OK);

	 }
	
	
	
	
}



