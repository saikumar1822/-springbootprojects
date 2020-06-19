package com.learn.Ecommerce1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.Ecommerce1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmailAndPassword(String email,String password);

}
