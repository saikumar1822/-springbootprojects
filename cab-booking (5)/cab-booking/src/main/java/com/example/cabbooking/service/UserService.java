package com.example.cabbooking.service;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.dto.UserRegistrationDto;
import com.example.cabbooking.model.User;
import com.example.cabbooking.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@SuppressWarnings("unused")
	private Random random = new SecureRandom();

	
	public User createUser(UserRegistrationDto userRegistrationDto) {
		Random random = new Random();
		User user = new User();
		BeanUtils.copyProperties(userRegistrationDto, user);
		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 10;

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		user.setPassword(generatedString);
		user = userRepository.save(user);
		return user;
	}
	

	}



