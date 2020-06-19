package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.User;
import com.hcl.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "getUserDetails")
	public String getUserDetails() {
		return "getUserDetails";
	}
	
	
	@RequestMapping(value = "updateUserDetails")
	public String updateUserDetails() {
		return "updateUserDetails";
	}

	@RequestMapping(value = "/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {

		User newUser = userService.addUser(user);
		return new ModelAndView("success","User",newUser);

	}

	@RequestMapping(value = "/getUser")
	public ModelAndView getUser(int id, @ModelAttribute User user) {
		
		User userDb = userService.getUserById(id);
		if(userDb != null) {
			
			return new ModelAndView("success","User",userDb);
		}
		 
		else {
			
			return new ModelAndView("error");
			
		}

	}
	
	@RequestMapping(value = "/getAllUserDetails")
	public ModelAndView getAllUser(@ModelAttribute User user) {
		
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.getAllUsers();
		modelAndView.addObject("listOfUsers", users);
		modelAndView.setViewName("listOfUsers");
		return modelAndView;

	}

	@RequestMapping(value = "/updateUser")
	public ModelAndView updateUser(int id, @ModelAttribute User user) {

		
		User userDb = userService.updateUser(user);
		return new ModelAndView("success","User",userDb);
		
	}

	@RequestMapping(value = "/deleteUser")
	public String deleteUser() {

		return null;
	}

}
