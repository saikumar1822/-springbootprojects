package com.example.cabbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.dto.UserDto;
import com.example.cabbooking.exceptions.UserNotFoundException;
import com.example.cabbooking.model.User;
import com.example.cabbooking.repository.UserRepository;


@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserRepository loginRepository;

	@Override
	public User login(UserDto userDto) {

		User login = loginRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
		if (login==null) {
			throw new UserNotFoundException("User doesnot exists");
		}
		
		
		return login;
		
	}
		
	}
	


