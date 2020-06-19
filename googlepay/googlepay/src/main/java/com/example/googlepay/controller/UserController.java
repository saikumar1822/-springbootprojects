package com.example.googlepay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.googlepay.dto.ResponseDto;
import com.example.googlepay.exception.RegistarionFailedException;
import com.example.googlepay.exception.UserNotFoundException;
import com.example.googlepay.model.User;
import com.example.googlepay.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/registration")

	public ResponseEntity<User> createUser(@RequestBody User user)throws RegistarionFailedException, UserNotFoundException {

		User user1 = userService.saveUser(user);

		return new ResponseEntity<User>(user1, HttpStatus.OK);

	}

}
