package com.product.SpringDataJpaUsingCustomQueries.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.product.SpringDataJpaUsingCustomQueries.model.Product;
import com.product.SpringDataJpaUsingCustomQueries.model.User;
import com.product.SpringDataJpaUsingCustomQueries.service.UserService;

import junit.framework.Assert;
@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;
	
	@Test
	public void testSaveUserForPositive() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("sai");
		Mockito.when(userService.save(Mockito.any(User.class))).thenReturn((user));
		ResponseEntity<User> resUser = userController.saveUser(user);
		Assert.assertNotNull(resUser);
		Assert.assertEquals("sai",user.getUserName());
	}
	
	@Test(expected = NullPointerException.class)
	public void testSaveUserForExc() {
		User user = new User();
		Mockito.when(userService.save(Mockito.any(User.class))).thenThrow(NullPointerException.class);
		ResponseEntity<User> resUser = userController.saveUser(user);
	}
	
}
