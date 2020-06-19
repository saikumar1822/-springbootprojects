package com.product.SpringDataJpaUsingCustomQueries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.SpringDataJpaUsingCustomQueries.Exception.InavalidCredentials;
import com.product.SpringDataJpaUsingCustomQueries.Exception.UserNotLoggedIn;
import com.product.SpringDataJpaUsingCustomQueries.model.User;
import com.product.SpringDataJpaUsingCustomQueries.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("User")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User user1= userService.save(user);
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}

	@PostMapping("User1")
	public ResponseEntity<User> userLogin(@RequestBody User user) {
		User user1= userService.getUserByName(user.getUserName());
		if(user.getPassword().equals(user1.getPassword()))
		{
			user1.setStatus(true);
			userService.save(user);
			return new ResponseEntity<User>(user1, HttpStatus.OK);
		}
		else {
			throw new InavalidCredentials();
		}	
	}
	@PostMapping("User2")
	public ResponseEntity<String> logout(@RequestBody User user) {
		User user1= userService.getUserByName(user.getUserName());
		if(user.getPassword().equals(user1.getPassword()))
		{
			user1.setStatus(false);
			userService.save(user);
			return new ResponseEntity<String>("user logged out successfully", HttpStatus.OK);
		}
		else {
			throw new InavalidCredentials();
		}
	}
	
	@PostMapping("User3")
	public ResponseEntity<String> isValidUser(@RequestParam String userName) {
		User user1= userService.getUserByName(userName);
		if(user1.isStatus())
		{
			return new ResponseEntity<String>("user logged in successfully", HttpStatus.OK);
		}
		else {
			throw new UserNotLoggedIn();
		}
	}
	
}
