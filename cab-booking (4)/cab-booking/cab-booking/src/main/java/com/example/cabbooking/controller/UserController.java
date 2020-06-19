package com.example.cabbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.cabbooking.dto.UserDto;
import com.example.cabbooking.dto.UserRegistrationDto;
import com.example.cabbooking.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	private UserDto userDto = new UserDto();

	@PostMapping(value = "/user")
	public ResponseEntity<Object> createUser(@RequestBody UserRegistrationDto userRegistrationDto) throws Exception {
		userDto = userService.createUser(userRegistrationDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);

	}

}
