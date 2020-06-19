package com.example.BankingApplication1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankingApplication1.model.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Customer findByEmailAndPassword(String email,String password);
	 public Customer findByPhoneNumber(String phoneNumber);



}
