package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.User;
import com.hcl.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/*@ResponseBody
	@RequestMapping(value = "login1")
	public String login1() {
		return "login";
	}*/
	
	
	

	@RequestMapping(value = "Registration")
	public String Registration() {
		return "registration";
	}
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
	
	@RequestMapping(value = "deleteUserDetails")
	public String deleteUserDetails() {
		return "deleteUserDetails";
	}

	@RequestMapping(value = "/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {

			User newUser = userService.addUser(user);
			return new ModelAndView("login","key1","details added successfully and enter the details to login");
		
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
		
		//ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.getAllUsers();
		return new ModelAndView("listOfUsers","listOfUsers",users);

	}

	@RequestMapping(value = "/updateUser")
	public ModelAndView updateUser(int id, @ModelAttribute User user) {

			try {
				User userDb = userService.updateUser(user);
				return new ModelAndView("redirect:/getAllUserDetails");
			}
			catch(Exception e) {
				return new ModelAndView("error");
			}
				
	}

	@RequestMapping(value = "/deleteUser")
	public ModelAndView deleteUser(int id, @ModelAttribute User user) {

		User userDb = userService.getUserById(id);
		
		if(userDb != null) {
			userService.deleteUser(userDb);
			return new ModelAndView("success","User",userDb);
		}
		else{
			return new ModelAndView("error");
		}
		
	}
	
	@RequestMapping(value = "/checkUser")
	public ModelAndView checkUser(int id, @ModelAttribute User user) {

		  User userDb = userService.getUserById(id); 
		  if(userDb != null&&user.getPassword().equals(userDb.getPassword())) {
		  
		  return new ModelAndView("success"); 
		  }
		  
		  else {
		  
		  return new ModelAndView("login","key","id or password is incorrect please try again" );
		  
		  }
		
	}
	
	
	}

