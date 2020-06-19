package com.hcl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.UserDto;
import com.hcl.dto.UserRegistrationDto;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private Random random= new Random();
	private User user =new User();
	private UserDto userDto=new UserDto();
	@Override
	public UserDto createUser(@Valid UserRegistrationDto userRegistrationDto) {
		BeanUtils.copyProperties(userRegistrationDto, user);

		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 10;
		
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		
		user.setPassword(generatedString);
		
		user=userRepository.save(user);
		
		BeanUtils.copyProperties(user, userDto);
		
		return userDto;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = (List<User>) userRepository.findAll();

		if (userList.size() > 0) {
			return userList;
		} else {
			return new ArrayList<User>();
		}
	}

	@Override
	public User getByPhone(String phone) {
		
		return userRepository.findByPhone(phone);
	}
    
}
