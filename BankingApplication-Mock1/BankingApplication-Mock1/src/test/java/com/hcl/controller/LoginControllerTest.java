package com.hcl.controller;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.dto.ResponseMesageDto;
import com.hcl.dto.UserDto;
import com.hcl.model.User;
import com.hcl.service.LoginService;



@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginControllerTest {
	
	@InjectMocks
	LoginController loginController;
	@Mock
	LoginService loginService;

	
	
	@Test
	public void testFindByCustomerIdAndPasswordForPositive() {
		User user=new User((long) 1, "jansi");
		UserDto userDto=new UserDto();
		Mockito.when(loginService.login(userDto)).thenReturn(user);
		ResponseEntity<ResponseMesageDto> user1=loginController.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
		
	}
	
	@Test
	public void testFindByCustomerIdAndPasswordForNegative() {
		User user=new User((long) -1, "jansi");
		UserDto userDto=new UserDto();
		Mockito.when(loginService.login(userDto)).thenReturn(user);
		ResponseEntity<ResponseMesageDto> user1=loginController.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
		
	}
	

	

}

