package com.example.googlepay.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.googlepay.dto.TransferDto;
import com.example.googlepay.exception.AmountNotFoundException;
import com.example.googlepay.exception.InsufficientBalance;
import com.example.googlepay.exception.PhoneNumberNotFoundException;
import com.example.googlepay.exception.TransactionNotFound;
import com.example.googlepay.exception.UserNotFoundException;
import com.example.googlepay.model.Transaction;
import com.example.googlepay.model.User;
import com.example.googlepay.repository.TransactionRepository;
import com.example.googlepay.repository.UserRepository;

@Service
public class TransactionService {
	private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;
    @LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	Date date = new Date();

	public String payment(TransferDto transferDto)
			throws PhoneNumberNotFoundException, AmountNotFoundException, InsufficientBalance {
		logger.info("phone number validation");
		if (transferDto.getToPhoneNumber().length() >= 10 && transferDto.getToPhoneNumber().length() >= 10) {
			logger.info("amuont validation");
			if (transferDto.getAmount() != 0) {

				Transaction transaction = new Transaction();
				User user = new User();
				user.setUserId(2);
				transaction.setUser(user);
				transaction.setAmount(transferDto.getAmount());
				transaction.setToPhone(transferDto.getToPhoneNumber());
				transaction.setTransactionDate(date);

				String amount = Integer.toString(transferDto.getAmount());

				String url = "http://BANK-SERVICE/transaction1";

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
				logger.info("rest template get metgod calling ");
				
					String result = restTemplate.getForObject(builder.toUriString(), String.class);
					logger.info("saving transaction");
					saveTrasaction(transaction);
					return result;
				
			} else {
				throw new AmountNotFoundException("please enter the amount");
			}
		} else {
			throw new PhoneNumberNotFoundException("check your  phone numbers");
		}

	}
	public String getByPhoneNo(String phoneNo) throws UserNotFoundException {

		String url = "http://BANK-SERVICE/phoneno/" + phoneNo;

		try {

			String result = restTemplate.getForObject(url, String.class);

			return result;

		} catch (Exception e) {

			throw new UserNotFoundException(phoneNo);

		}

	}


	public void saveTrasaction(Transaction transaction) {
		transactionRepository.save(transaction);

	}
	public List<Transaction> getTransactions(String phoneNo) {

		  List<Transaction> transactions;

		  User user=new User();

		  user = userRepository.findByPhoneNo(phoneNo);

		  transactions=transactionRepository.findTransactionByUser(user);

		  if(transactions.isEmpty()) {

		  throw new TransactionNotFound();

		  }
		 return transactions;

		 }


}
