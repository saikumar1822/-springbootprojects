package com.hcl.RestTemplateDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.RestTemplateDemo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("User")
	public String listAllProducts() {
		 return  userService.listAllProducts();
	}
	@GetMapping("user/{userId}")
	public String getProductByPathVar(@PathVariable String userId) {
		 return  userService.getProductByPathVar(userId);
	}


}
