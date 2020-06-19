package com.example.cabbooking.service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.cabbooking.dto.UserDto;
import com.example.cabbooking.exceptions.UserNotfoundException;
import com.example.cabbooking.model.User;
import com.example.cabbooking.repository.UserRepository;


@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceImplTest {
  @InjectMocks
    LoginServiceImpl loginServiceImpl;
    @Mock
    UserRepository LoginRepository;
    
    @Test(expected = UserNotfoundException.class)
    public void testFindByEmailAndPasswordForException() throws UserNotfoundException {
        User user = new User();
        UserDto userDto = new UserDto();
        userDto.setPassword("chandhu");
        Mockito.when(LoginRepository.findByEmailAndPassword((String) "chan", "chandhini")).thenReturn(user);
        User user1 = loginServiceImpl.login(userDto);
        Assert.assertNotNull(user1);
        Assert.assertEquals("chandhu", user1.getPassword());
    }
    
    @Test(expected = UserNotfoundException.class)
    public void testFindByEmailAndPasswordForException1() throws UserNotfoundException {
        User user = new User();
        UserDto userDto = new UserDto();
        userDto.setPassword("chandhu");
        Mockito.when(LoginRepository.findByEmailAndPassword((String) "chan", "chandhini")).thenReturn(user);
        User user1 = loginServiceImpl.login(userDto);
        Assert.assertNotNull(user1);
        Assert.assertEquals("chandhu", user1.getPassword()); 

}

}
