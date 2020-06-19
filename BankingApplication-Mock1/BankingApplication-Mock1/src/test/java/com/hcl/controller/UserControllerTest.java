package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.dto.UserDto;
import com.hcl.dto.UserRegistrationDto;
import com.hcl.model.User;
import com.hcl.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Test
	public void testCreateUserForPositive() throws Exception {
		User user = new User((long) 1, "jansi", "Jansi", "Female", "5478934567", "SE", "Tirupur");
		UserRegistrationDto userRegistrationDto= new UserRegistrationDto();
		UserDto userDto= new UserDto();
		Mockito.when(userService.createUser(userRegistrationDto)).thenReturn(userDto);
		ResponseEntity<Object> user1 = userController.addUser(userRegistrationDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	}

	@Test
	public void testCreateUserForNegative() throws Exception {
		User user = new User((long) -1, "jansi", "Jansi", "Female", "5478934567", "SE", "Tirupur");
		UserRegistrationDto userRegistrationDto= new UserRegistrationDto();
		UserDto userDto= new UserDto();
		Mockito.when(userService.createUser(userRegistrationDto)).thenReturn(userDto);
		ResponseEntity<Object> user1 = userController.addUser(userRegistrationDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	}

	@Test
	public void testGetAllUsersForPositive() {

		List<User> users = new ArrayList<User>();
		User user = new User((long) 1, "jansi", "Jansi", "Female", "5478934567", "SE", "Tirupur");
		users.add(user);
		Mockito.when(userService.getAllUsers()).thenReturn(users);
		ResponseEntity<List<User>> re = userController.getAllUsers(user);
		Assert.assertNotNull(re);
		Assert.assertEquals(HttpStatus.OK, re.getStatusCode());

	}

	@Test
	public void testGetAllUsersForNegative() {

		List<User> users = new ArrayList<User>();
		User user = new User((long) -1, "jansi", "Jansi", "Female", "5478934567", "SE", "Tirupur");
		users.add(user);
		Mockito.when(userService.getAllUsers()).thenReturn(users);
		ResponseEntity<List<User>> re = userController.getAllUsers(user);
		Assert.assertNotNull(re);
		Assert.assertEquals(HttpStatus.OK, re.getStatusCode());

	}

}
