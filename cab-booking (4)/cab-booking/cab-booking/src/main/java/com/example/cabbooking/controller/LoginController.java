package com.example.cabbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabbooking.dto.ResponseMessageDto;
import com.example.cabbooking.dto.UserDto;
import com.example.cabbooking.exceptions.UserNotfoundException;
import com.example.cabbooking.service.LoginService;



@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	@PostMapping("/login")
	public ResponseEntity<ResponseMessageDto> login(@RequestBody UserDto userDto) throws UserNotfoundException  {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		loginService.login(userDto);
		responseMessageDto.setMessage("user Logged in Sucessfully");
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);

	}

}
