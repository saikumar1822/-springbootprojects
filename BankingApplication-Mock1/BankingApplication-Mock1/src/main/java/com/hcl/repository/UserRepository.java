package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hcl.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByCustomerIdAndPassword(Long cId, String password);
	User findByPhone(String phone);
	
	}
