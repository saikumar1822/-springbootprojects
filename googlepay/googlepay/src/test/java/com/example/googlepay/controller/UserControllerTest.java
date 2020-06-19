package com.example.googlepay.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.googlepay.exception.RegistarionFailedException;
import com.example.googlepay.exception.UserNotFoundException;
import com.example.googlepay.model.User;
import com.example.googlepay.service.UserService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)

public class UserControllerTest {

	@InjectMocks

	UserController userController;

	@Mock

	UserService userService;

	@Test

	public void testcreateUser() throws UserNotFoundException, RegistarionFailedException {

		User user = new User();

		user.setUserId(1);

		user.setUserName("kavya");

		user.setEmail("kavya@gmail.com");

		user.setPhoneNo("7989666952");

		user.setAddress("srikakulam");

		userController.createUser(user);

		Mockito.when(userService.saveUser(user)).thenReturn(user);

		ResponseEntity<User> user1 = userController.createUser(user);

		Assert.assertNotNull(user1);

		Assert.assertEquals(user.getPhoneNo(), "7989666952");

	}

	@Test(expected = Exception.class)

	public void testcreateUserForExce() throws UserNotFoundException, RegistarionFailedException {

		User user = new User();

		user.setUserId(1);

		user.setUserName("kavya");

		user.setEmail("kavya@gmail.com");

		user.setPhoneNo("7989666952");

		user.setAddress("srikakulam");

		userController.createUser(user);

		Mockito.when(userService.saveUser(user)).thenThrow(Exception.class);

		ResponseEntity<User> user1 = userController.createUser(user);

		Assert.assertNotNull(user1);

		Assert.assertEquals(user.getPhoneNo(), "9515890910");

	}

}