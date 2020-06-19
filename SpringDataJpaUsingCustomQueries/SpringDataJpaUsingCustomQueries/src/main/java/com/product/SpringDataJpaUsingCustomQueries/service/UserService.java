package com.product.SpringDataJpaUsingCustomQueries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.SpringDataJpaUsingCustomQueries.Exception.UserNotFoundException;
import com.product.SpringDataJpaUsingCustomQueries.model.User;
import com.product.SpringDataJpaUsingCustomQueries.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		
		return userRepository.save(user);
	}

	public User getUserByName(String userName) {
		try {
			return userRepository.findByUserName(userName);
		}
		catch (Exception e) {
			throw new UserNotFoundException();
		}

	}

}
