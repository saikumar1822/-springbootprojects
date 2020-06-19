package com.hcl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Account;

@Repository
public interface AccountRepositary extends JpaRepository<Account, Long>{
	
	Optional<Account> findAccountByAccountNumber(int accno);

}

