package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Trasnsction;

public interface TransactionRepositary extends JpaRepository<Trasnsction, Integer>{

}