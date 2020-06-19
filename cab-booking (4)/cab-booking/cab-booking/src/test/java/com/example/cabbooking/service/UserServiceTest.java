package com.example.cabbooking.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.example.cabbooking.dto.ResponseMessageDto;
import com.example.cabbooking.dto.UserRegistrationDto;
import com.example.cabbooking.model.User;
import com.example.cabbooking.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {
	@Mock
	UserRepository userRepository;
	@InjectMocks
	UserService userService;
	static User user=null;
	static UserRegistrationDto dto=null;
	@BeforeClass
public static void setUp() {
		
		user=new User();
		dto=new UserRegistrationDto();
		user.setEmail("sowjanya");
		user.setPassword("sowjanya123");
		dto.setEmail("sowjanya");
		dto.setPassword("sowjanya123");
		BeanUtils.copyProperties(dto, user);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testUserRegestration() {
		UserRegistrationDto dto=new UserRegistrationDto();
		ResponseMessageDto message=new ResponseMessageDto();
		dto.setEmail("sowjanya");
		dto.setPassword("sowjanya123");
		user.setEmail("sowjanya");
		user.setPassword("sowjanya123");
		BeanUtils.copyProperties(dto, user);
		message.setMessage("registration done");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		userService.createUser(dto);
		
		
		
	}
	
}
