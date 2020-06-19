package com.example.googlepay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.googlepay.exception.RegistarionFailedException;
import com.example.googlepay.exception.UserNotFoundException;
import com.example.googlepay.model.User;
import com.example.googlepay.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
@Autowired
	TransactionService transactionService;
	
	public User saveUser(User user) throws RegistarionFailedException, UserNotFoundException {

		transactionService.getByPhoneNo(user.getPhoneNo());

		try {

			userRepository.save(user);

			return user;

		}

		catch (Exception e) {

			throw new RegistarionFailedException();

		}

	}

}
