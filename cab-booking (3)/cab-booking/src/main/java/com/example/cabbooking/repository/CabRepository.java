package com.example.cabbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cabbooking.model.Cab;

public interface CabRepository extends JpaRepository<Cab, Long> {

}
