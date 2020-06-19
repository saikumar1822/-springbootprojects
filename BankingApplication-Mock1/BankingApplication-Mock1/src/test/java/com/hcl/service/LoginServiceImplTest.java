package com.hcl.service;




import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.Exception.UserNotfoundException;
import com.hcl.dto.UserDto;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;



@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceImplTest {

	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	@Mock
	UserRepository LoginRepository;

	

	@Test
	public void testFindByCustomerIdAndPasswordForPositive() {
		User user=new User((long) 1, "jansi");
		UserDto userDto = new UserDto();
		userDto.setCustomerId(1l);
		userDto.setPassword("jansi");
		Mockito.when(LoginRepository.findByCustomerIdAndPassword((long)1, "jansi")).thenReturn(user);
		User user1=loginServiceImpl.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals("jansi",user1.getPassword());
		
	}
	
	@Test
	public void testFindByCustomerIdAndPasswordForNegative() {
		User user=new User((long) -1, "jansi");
		UserDto userDto = new UserDto();
		userDto.setCustomerId(-1l);
		userDto.setPassword("jansi");
		Mockito.when(LoginRepository.findByCustomerIdAndPassword((long)-1, "jansi")).thenReturn(user);
		User user1=loginServiceImpl.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals("jansi",user1.getPassword());
		
	}
	
	@Test(expected = UserNotfoundException.class)
	public void testFindByCustomerIdAndPasswordForException()throws UserNotfoundException {
		User user=new User((long) 3, "jansi");
		UserDto userDto = new UserDto();

		Mockito.when(LoginRepository.findByCustomerIdAndPassword((long)1, "jansi")).thenReturn(user);
		User user1=loginServiceImpl.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals("jansi",user1.getPassword());
		
	}
	
	
	
	
	
}
