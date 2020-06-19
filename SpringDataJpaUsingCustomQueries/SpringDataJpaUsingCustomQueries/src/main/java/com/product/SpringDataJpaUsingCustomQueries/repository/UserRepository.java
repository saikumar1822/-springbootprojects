package com.product.SpringDataJpaUsingCustomQueries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.SpringDataJpaUsingCustomQueries.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
public User findByUserName(String userName);

}
