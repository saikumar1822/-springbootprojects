package com.hcl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Banificiary;

@Repository
public interface BenificiaryRepositary extends JpaRepository<Banificiary, Long> {
	
	Optional<Banificiary> findBanificiaryByBanificiaryAccountNo(Long Baccno);	

}