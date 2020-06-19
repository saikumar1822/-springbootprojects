package com.example.cabbooking.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.cabbooking.dto.ResponseMessageDto;
import com.example.cabbooking.dto.UserDto;
import com.example.cabbooking.exceptions.UserNotFoundException;
import com.example.cabbooking.model.User;
import com.example.cabbooking.service.LoginService;



@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginControllerTest {

    @InjectMocks
    LoginController loginController;
    @Mock
    LoginService loginService;


	    @Test
	    public void testFindByUserNameAndPasswordForPositive() throws UserNotFoundException {
	        User userLogin = new User();
	        UserDto userDto = new UserDto();
	        Mockito.when(loginService.login(userDto)).thenReturn(userLogin);
	        ResponseEntity<ResponseMessageDto> user1 = loginController.login(userDto);
	        Assert.assertNotNull(user1);
	        Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	    }
	    @Test
	    public void testFindByCustomerIdAndPasswordForNegative() throws UserNotFoundException {
	        User userLogin = new User();
	        UserDto userDto = new UserDto();
	        Mockito.when(loginService.login(userDto)).thenReturn(userLogin);
	        ResponseEntity<ResponseMessageDto> user1 = loginController.login(userDto);
	        Assert.assertNotNull(user1);
	        Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());

	 

	    }
	}

