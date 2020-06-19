package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.ResponseMesageDto;
import com.hcl.dto.UserDto;
import com.hcl.model.User;
import com.hcl.service.LoginService;


@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	private ResponseMesageDto dto = new ResponseMesageDto();

	@PostMapping(value = "/login")
	public ResponseEntity<ResponseMesageDto> login(@RequestBody UserDto userDto) {
	    
		 loginService.login(userDto);
		dto.setMessage("user Logged in Sucessfully");
		return new ResponseEntity<>(dto, HttpStatus.OK);

	
}
}
