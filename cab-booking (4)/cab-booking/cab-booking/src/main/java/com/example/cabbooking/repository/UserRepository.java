package com.example.cabbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cabbooking.model.User;
@Repository
 public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmailAndPassword(String email, String password);

}


