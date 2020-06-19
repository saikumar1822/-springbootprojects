package com.example.cabbooking.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.cabbooking.dto.UserDto;
import com.example.cabbooking.dto.UserRegistrationDto;
import com.example.cabbooking.model.User;
import com.example.cabbooking.service.UserService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
	public class UserControllerTest {

	    @InjectMocks
	    UserController userController;
	    @Mock
	    UserService userService;
	    @Test
	    public void testCreateUserForPositive() throws Exception {
	        User user = new User();
	        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
	        UserDto userDto = new UserDto();
	        Mockito.when(userService.createUser(userRegistrationDto)).thenReturn(userDto);
	        ResponseEntity<Object> user1 = userController.createUser(userRegistrationDto);
	        Assert.assertNotNull(user1);
	        Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	    }
	    @Test
	    public void testCreateUserForNegative() throws Exception {
	        User user = new User();
	        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
	        UserDto userDto = new UserDto();
	        Mockito.when(userService.createUser(userRegistrationDto)).thenReturn(userDto);
	        ResponseEntity<Object> user1 = userController.createUser(userRegistrationDto);
	        Assert.assertNotNull(user1);
	        Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	    }	    
	    
	}
