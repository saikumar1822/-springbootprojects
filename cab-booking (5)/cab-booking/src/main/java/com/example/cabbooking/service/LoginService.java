package com.example.cabbooking.service;

import com.example.cabbooking.dto.UserDto;
import com.example.cabbooking.exceptions.UserNotFoundException;
import com.example.cabbooking.model.User;

public interface LoginService {

	User login(UserDto userDto) throws UserNotFoundException;

}
