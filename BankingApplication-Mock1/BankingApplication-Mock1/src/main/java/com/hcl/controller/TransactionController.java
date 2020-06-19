package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.TrasnsctionDto;
import com.hcl.model.Tranfer;
import com.hcl.model.Trasnsction;
import com.hcl.service.TransacService;

@RestController
public class TransactionController {

	@Autowired
	TransacService transactionservice;

	@PostMapping("/transaction")
	public ResponseEntity<Object> transaction(@RequestBody Trasnsction trasnsction) {
		TrasnsctionDto trasnsctionDto = new TrasnsctionDto();
		trasnsctionDto = transactionservice.transaction(trasnsction);
		trasnsctionDto.setMessage("Transaction is sucessfull");
		return new ResponseEntity<>(trasnsctionDto, HttpStatus.OK);

	}
	
	@GetMapping("/payment")
	public ResponseEntity<Object> transfer(@RequestParam String phoneNo,@RequestParam String toPhoneNo,@RequestParam Double amount) {
		Tranfer t1=new Tranfer();
		t1.setAmount(amount);
		t1.setPhoneNo(phoneNo);
		t1.setToPhoneNo(toPhoneNo);
		transactionservice.createTransac(t1);
		
		return new ResponseEntity<>(t1, HttpStatus.OK);
	}
	
	
	
}
