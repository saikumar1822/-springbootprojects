package com.hcl.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.UserDto;
import com.hcl.dto.UserRegistrationDto;
import com.hcl.model.User;
import com.hcl.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private UserDto userDto=new UserDto();

	@PostMapping(value = "/user")
	public ResponseEntity<Object> addUser(@Valid @RequestBody UserRegistrationDto UserRegistrationDto)throws Exception {
		userDto= userService.createUser(UserRegistrationDto);
		return new ResponseEntity<>(userDto, HttpStatus.OK);

	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers(User user) {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/{phone}")
	public ResponseEntity<Object> getByPhone(@PathVariable String phone) {
		User users = userService.getByPhone(phone);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	
}
