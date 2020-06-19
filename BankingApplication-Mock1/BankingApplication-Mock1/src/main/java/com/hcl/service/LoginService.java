package com.hcl.service;


import com.hcl.dto.UserDto;
import com.hcl.model.User;


public interface LoginService {
	User login(UserDto userDto);
}

