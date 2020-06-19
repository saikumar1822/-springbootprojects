package com.example.googlepay.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.googlepay.exception.RegistarionFailedException;
import com.example.googlepay.exception.UserNotFoundException;
import com.example.googlepay.model.User;
import com.example.googlepay.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)

public class UserServiceTest {

	@InjectMocks

	UserService userService;

	@Mock

	UserRepository userRepository;

	@Test

	public void testcreateUser() throws UserNotFoundException, RegistarionFailedException {

		User user = new User();

		user.setUserId(1);

		user.setUserName("kavya");

		user.setEmail("kavya@gmail.com");

		user.setPhoneNo("7989666952");

		user.setAddress("srikakulam");

		// userService.saveUser(user);

		// Mockito.verify(userRepository, Mockito.times(1)).save(user);

	}

	@Test(expected = Exception.class)

	public void testcreateUserForExce() throws UserNotFoundException, RegistarionFailedException {

		User user = new User();

		user.setUserId(1);

		user.setUserName("kavya");

		user.setEmail("kavya@gmail.com");

		user.setPhoneNo("7989666952");

		user.setAddress("srikakulam");

		userService.saveUser(user);

		Mockito.when(userRepository.save(user)).thenThrow(Exception.class);

		User user1 = userService.saveUser(user);

		Assert.assertNotNull(user1);

		Assert.assertEquals(user.getPhoneNo(), "9515890910");

	}

}
