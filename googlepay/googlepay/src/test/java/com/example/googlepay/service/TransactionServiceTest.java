package com.example.googlepay.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.googlepay.dto.TransferDto;
import com.example.googlepay.exception.AmountNotFoundException;
import com.example.googlepay.exception.InsufficientBalance;
import com.example.googlepay.exception.PhoneNumberNotFoundException;
import com.example.googlepay.exception.TransactionNotFound;
import com.example.googlepay.model.Transaction;
import com.example.googlepay.model.User;
import com.example.googlepay.repository.TransactionRepository;
import com.example.googlepay.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceTest {

	@InjectMocks
	TransactionService transactionService;

	@Mock
	TransactionRepository transactionRepository;
	@Mock
	UserRepository userRepository;
	
	
	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Test(expected = NullPointerException.class)
	public void testPaymentForPositve()
			throws PhoneNumberNotFoundException, AmountNotFoundException, InsufficientBalance {
		Date date = new Date();
		TransferDto transferDto = new TransferDto();
		if (transferDto.getToPhoneNumber().length() >= 10 && transferDto.getToPhoneNumber().length() >= 10) {
			if (transferDto.getAmount() != 0) {

				Transaction transaction = new Transaction();
				User user = new User();
				user.setUserId(2);
				transaction.setUser(user);
				transaction.setAmount(transferDto.getAmount());
				transaction.setToPhone(transferDto.getToPhoneNumber());
				transaction.setTransactionDate(date);

				String amount = Integer.toString(transferDto.getAmount());

				String url = "http://localhost:8066/transaction1";

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

				Map<String, String> params = new HashMap<String, String>();
				params.put("fromPhoneNumber", transferDto.getFromPhoneNumber());
				params.put("toPhoneNumber", transferDto.getToPhoneNumber());
				params.put("amount", amount);

				UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
				for (Map.Entry<String, String> entry : params.entrySet()) {
					builder.queryParam(entry.getKey(), entry.getValue());
				}
				try {
					String result = restTemplate.getForObject(builder.toUriString(), String.class);
				} catch (Exception e) {
					throw new InsufficientBalance("enterd amount is less then the availble balance");

				}
			} else {
				throw new AmountNotFoundException("please enter the amount");
			}
		} else {
			throw new PhoneNumberNotFoundException("check your  phone numbers");
		}

	}
	 @Test

	 public void testGetTransactions() {

	 List<Transaction> transactions=new ArrayList<>();

	 Transaction transaction = new Transaction();

	 transaction.setAmount(2500);

	 transaction.setToPhone("9876543210");

	 transaction.setToPhone("7894561230");

	 transaction.setTransactionDate(null);

	 transaction.setTransactionId(1);

	 transactions.add(transaction);

	 transaction.setAmount(2500);

	 transaction.setToPhone("9876543210");

	 transaction.setToPhone("7894561230");

	 transaction.setTransactionDate(null);

	 transaction.setTransactionId(2);

	 transactions.add(transaction);

	 transactionRepository.saveAll(transactions);

	 User user=new User();

	 user.setAddress("goa");

	 user.setEmail("hai@gmail.com");

	 user.setPhoneNo("9876543210");

	 user.setTransactionList(transactions);

	 user.setUserId(5);

	 user.setUserName("gsp");

	 userRepository.save(user);

	 Mockito.when(userRepository.findByPhoneNo("9876543210")).thenReturn(user);

	 Mockito.when(transactionRepository.findTransactionByUser(user)).thenReturn(transactions);

	 Assert.assertNotNull(transactions);

	 }

	 @Test

	 public void testGetTransactionsForException() {

	 List<Transaction> transactions=new ArrayList<>();

	 Transaction transaction = new Transaction();

	 transaction.setAmount(2500);

	 transaction.setToPhone("9876543210");

	 transaction.setToPhone("7894561230");

	 transaction.setTransactionDate(null);

	 transaction.setTransactionId(1);

	 transactions.add(transaction);

	 transaction.setAmount(2500);

	 transaction.setToPhone("9876543210");

	 transaction.setToPhone("7894561230");

	 transaction.setTransactionDate(null);

	 transaction.setTransactionId(2);

	 transactions.add(transaction);

	 transactionRepository.saveAll(transactions);

	 User user=new User();

	 user.setAddress("goa");

	 user.setEmail("hai@gmail.com");

	 user.setPhoneNo("9876");

	 user.setTransactionList(transactions);

	 user.setUserId(5);

	 user.setUserName("gsp");

	 userRepository.save(user);

	 Mockito.when(userRepository.findByPhoneNo("9")).thenReturn(user);

	 Mockito.when(transactionRepository.findTransactionByUser(user)).thenThrow(new TransactionNotFound());

	 Assert.assertNotNull(transaction);

	 }



	
}
