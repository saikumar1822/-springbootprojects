package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.UserDao;
import com.hcl.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User addUser(User user) {

		
		return userDao.addUser(user);
	}

	public User getUserById(int id) {

		System.out.println("service");
		return userDao.getUserById(id);
	}
	

	public List<User> getAllUsers() {
		
		return userDao.getAllUsers();
	}

	public User updateUser(User user) {

		return userDao.updateUser(user);
	}

	public User deleteUser(User user) {

		return userDao.deleteUser(user);
	}

	

}
