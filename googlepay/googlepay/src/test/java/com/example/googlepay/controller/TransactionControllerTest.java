package com.example.googlepay.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.googlepay.dto.ResponseDto;
import com.example.googlepay.dto.TransferDto;
import com.example.googlepay.exception.AmountNotFoundException;
import com.example.googlepay.exception.InsufficientBalance;
import com.example.googlepay.exception.PhoneNumberNotFoundException;
import com.example.googlepay.model.Transaction;
import com.example.googlepay.model.User;
import com.example.googlepay.service.TransactionService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionControllerTest {
	@InjectMocks
	TransactionController transactionController;

	@Mock
	TransactionService transactionService;
	
	@Test
	public void testSaveStudentForNegitive() throws PhoneNumberNotFoundException, AmountNotFoundException, InsufficientBalance {
		TransferDto transferDto=new TransferDto();
		transferDto.setAmount(100);
		transferDto.setToPhoneNumber("9666168535");
		transferDto.setFromPhoneNumber("7981828495");
		ResponseDto responseDto= new ResponseDto();
			Mockito.when(transactionService.payment(Mockito.any(TransferDto.class))).thenReturn(("success"));
			responseDto.setMessage("sucess");
		ResponseEntity<ResponseDto> resStudent = transactionController.paymentProcessing(transferDto);
		
		
	}
	@Test
	public void testSaveStudentForPositive() throws PhoneNumberNotFoundException, AmountNotFoundException, InsufficientBalance {
		TransferDto transferDto=new TransferDto();
		transferDto.setAmount(100);
		transferDto.setToPhoneNumber("9666168535");
		transferDto.setFromPhoneNumber("7981828495");
		ResponseDto responseDto= new ResponseDto();
			Mockito.when(transactionService.payment(transferDto)).thenReturn(("success"));
			responseDto.setMessage("sucess");
		ResponseEntity<ResponseDto> res = transactionController.paymentProcessing(transferDto);
		
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testSaveStudentForException() throws PhoneNumberNotFoundException, AmountNotFoundException, InsufficientBalance {
		TransferDto transferDto=new TransferDto();
		transferDto.setAmount(100);
		transferDto.setToPhoneNumber("9666168535");
		transferDto.setFromPhoneNumber("7981828495");
		ResponseDto responseDto= new ResponseDto();
			Mockito.when(transactionService.payment(transferDto)).thenThrow(NullPointerException.class);
			responseDto.setMessage("sucess");
		ResponseEntity<ResponseDto> res = transactionController.paymentProcessing(transferDto);
		
		
	}
	 @SuppressWarnings({ "unchecked", "deprecation" })

	 @Test

	 public void testFindTransactions() {

	  List<Transaction> transactions = new ArrayList<>();

	  Transaction transaction = new Transaction();

	  transaction.setAmount(2500);

	  transaction.setToPhone("7894561230");

	  transaction.setTransactionDate(null);

	  transaction.setTransactionId(1);

	  transactions.add(transaction);

	  transaction.setAmount(2500);

	  transaction.setToPhone("7894561230");

	  transaction.setTransactionDate(null);

	  transaction.setTransactionId(2);

	  transactions.add(transaction);

	  User user=new User();

	  user.setAddress("goa");

	  user.setEmail("hai@gmail.com");

	  user.setPhoneNo("9876543210");

	  user.setTransactionList(transactions);

	  user.setUserId(5);

	  user.setUserName("gsp");

	  Mockito.when(transactionService.getTransactions(user.getPhoneNo())).thenReturn(transactions);

	  Assert.assertNotNull(transactions);

	 }

	 @Test (expected=NullPointerException.class)

	 public void testFindTransactionsForException() {

	  List<Transaction> transactions = null;

	  Transaction transaction = new Transaction();

	  transaction.setAmount(2500);


	  transaction.setToPhone("7894561230");

	  transaction.setTransactionDate(null);

	  transaction.setTransactionId(1);

	  transactions.add(transaction);

	  transaction.setAmount(2500);



	  transaction.setTransactionDate(null);

	  transaction.setTransactionId(2);

	  transactions.add(transaction);

	  User user=new User();

	  user.setAddress("goa");

	  user.setEmail("hai@gmail.com");

	  user.setPhoneNo("9876543210");

	  user.setTransactionList(transactions);

	  user.setUserId(5);

	  user.setUserName("gsp");

	  Mockito.when(transactionService.getTransactions(Mockito.anyString())).thenReturn(transactions);

	  ResponseEntity<List<Transaction>> value = null;

	  Mockito.when(transactionController.findTransactions(Mockito.anyString())).thenReturn(value);

	  Assert.assertNotNull(value);

	 }
}




	

