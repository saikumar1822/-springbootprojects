package com.example.BankingApplication1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.BankingApplication1.dto.TransferDto;
import com.example.BankingApplication1.exceptions.CustomerNotFoundException;
import com.example.BankingApplication1.exceptions.InsufficientBalance;
import com.example.BankingApplication1.exceptions.PhoneNumberNotFoundException;
import com.example.BankingApplication1.service.SavingsService;

@RestController
public class SavingsController {
	@Autowired
	SavingsService savingsService;

	@Autowired
	CustomerController customerController;

	/*
	 * @PostMapping("/transaction") public ResponseEntity<String>
	 * transfer(@RequestBody TransferDto transferdto) {
	 * customerController.isValidCustomer(transferdto.getCustomerId());
	 * savingsService.getSavingsAccount(transferdto);
	 * 
	 * return new ResponseEntity<String>("transaction was successfull",
	 * HttpStatus.OK);
	 * 
	 * }
	 */
	
	
	@GetMapping("/transaction")
	public ResponseEntity<String> transfer(@RequestParam Long accountNumber,@RequestParam long beneficiaryAccountNumber,@RequestParam int amount,@RequestParam long customerId) throws InsufficientBalance{
		customerController.isValidCustomer(customerId);
		savingsService.getSavingsAccount(accountNumber, amount, beneficiaryAccountNumber);

		return new ResponseEntity<String>("transaction was successfull", HttpStatus.OK);

	}
	@GetMapping("/transaction1")
	public ResponseEntity<String> transfer1(@RequestParam String fromPhoneNumber,@RequestParam String toPhoneNumber,@RequestParam int amount) throws PhoneNumberNotFoundException, CustomerNotFoundException, InsufficientBalance{
		savingsService.getSavingsAccountByPhoneNumber(fromPhoneNumber, amount, toPhoneNumber);

		return new ResponseEntity<String>("transaction was successfull", HttpStatus.OK);

	}
	
}
	


