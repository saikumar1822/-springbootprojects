package com.hcl.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.Exception.UserNotfoundException;
import com.hcl.dto.UserDto;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository loginRepository;
	private User user = new User();

	@Override
	public User login(UserDto userDto) {

		BeanUtils.copyProperties(userDto, user);

		User login = loginRepository.findByCustomerIdAndPassword(user.getCustomerId(), user.getPassword());
		if (login == null) {
			throw new UserNotfoundException("Enter correct Id and Password");
		}
		if (!login.getPassword().equals(user.getPassword())) {
			throw new UserNotfoundException("Password mismatch");
		}
		return login;
	}

}
