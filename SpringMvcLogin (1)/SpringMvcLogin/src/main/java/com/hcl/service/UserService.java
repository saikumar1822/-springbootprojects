package com.hcl.service;

import java.util.List;

import com.hcl.model.User;

public interface UserService {
	
	public abstract User addUser(User user);

	public abstract User getUserById(int id);

	public abstract List<User> getAllUsers();
	
	public abstract User updateUser(User user);

	public abstract User deleteUser(User user);
}
