package com.example.cabbooking.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabbooking.dto.UserDto;
import com.example.cabbooking.dto.UserRegistrationDto;
import com.example.cabbooking.model.User;
import com.example.cabbooking.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	private UserDto userDto = new UserDto();

	@PostMapping("/register")
	public ResponseEntity<Object> userRegister(@RequestBody @Valid UserRegistrationDto userRegistrationDto) throws Exception {
		User user = userService.createUser(userRegistrationDto);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}

}
