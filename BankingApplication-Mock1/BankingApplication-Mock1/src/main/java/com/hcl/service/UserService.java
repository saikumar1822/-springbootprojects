package com.hcl.service;

import java.util.List;

import com.hcl.dto.UserDto;
import com.hcl.dto.UserRegistrationDto;
import com.hcl.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public UserDto createUser(UserRegistrationDto userRegistrationDto);
	public User getByPhone(String phone);
	
}
