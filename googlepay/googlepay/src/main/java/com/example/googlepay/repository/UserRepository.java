package com.example.googlepay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.googlepay.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByPhoneNo(String phoneNo);

}
