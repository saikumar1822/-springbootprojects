package com.product.SpringDataJpaUsingCustomQueries.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.product.SpringDataJpaUsingCustomQueries.Exception.ProductNotFoundException;
import com.product.SpringDataJpaUsingCustomQueries.Exception.UserNotFoundException;
import com.product.SpringDataJpaUsingCustomQueries.model.Product;
import com.product.SpringDataJpaUsingCustomQueries.model.User;
import com.product.SpringDataJpaUsingCustomQueries.repository.ProductRepository;
import com.product.SpringDataJpaUsingCustomQueries.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {
	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;
	
	@Test
	public void testSaveForPositive() {
		User user=new User();
		user.setUserId(1);
		user.setPassword("kumar");
		user.setUserName("sai");
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn((user));
		User resUser = userService.save(user);
		Assert.assertNotNull(resUser);
		Assert.assertEquals(user.getUserName(), resUser.getUserName());
	}

	@Test(expected = NullPointerException.class)
	public void testSaveForNegitive() {
		User user=new User();
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenThrow(NullPointerException.class);
		User resUser = userService.save(user);
	}
	@Test
	public void testgetUserByNameForPositive()  {
		User user = new User();
		user.setUserId(1);
		user.setUserName("kumar");
		user.setPassword("sai");
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(user);

		User user1 = userService.getUserByName("sai");
		Assert.assertNotNull(user1);
		Assert.assertEquals(user.getUserName(), user1.getUserName());
	}
	@Test(expected = UserNotFoundException.class)
	public void testgetUserByNameForExce() throws UserNotFoundException {
		User user = new User();
		user.setUserId(1);
		user.setUserName("kumar");
		user.setPassword("sai");
		Mockito.when(userRepository.findByUserName("sai")).thenThrow(UserNotFoundException.class);

		User resUser = userService.getUserByName("sai");
	}
}
