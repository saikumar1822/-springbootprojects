package com.hcl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.hcl.dto.UserDto;
import com.hcl.dto.UserRegistrationDto;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	@Test
	public void testGetAllUsersForPositive() {
		List<User> users = new ArrayList<User>();
		User user = new User((long) 1, "jansi", "Jansi", "Female", "5478934567", "SE", "Tirupur");
		users.add(user);
		Mockito.when(userRepository.findAll()).thenReturn(users);
		List<User> user1 = userServiceImpl.getAllUsers();
		Assert.assertNotNull(user1);
		Assert.assertEquals(1, user1.size());

	}

	@Test
	public void testGetAllProductsForNegative() {
		List<User> users = new ArrayList<User>();
		User user = new User((long) -1, "jansi", "Jansi", "Female", "5478934567", "SE", "Tirupur");
		users.add(user);
		Mockito.when(userRepository.findAll()).thenReturn(users);
		List<User> user1 = userServiceImpl.getAllUsers();
		Assert.assertNotNull(user1);
		Assert.assertEquals(1, user1.size());

	}

	@Test
	public void testCreateUserForPositive() {
		User user = new User((long) 1, "jansi", "Jansi", "Female", "5478934567", "SE", "Tirupur");
	
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assert.assertEquals(user, userRepository.save(user));
	}

	@Test
	public void testCreateStudentForNegative() {
		User user = new User((long) -1, "jansi", "Jansi", "Female", "5478934567", "SE", "Tirupur");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assert.assertEquals(user, userRepository.save(user));
	}

}
