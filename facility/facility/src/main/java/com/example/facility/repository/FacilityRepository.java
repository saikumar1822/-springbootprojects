package com.example.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.facility.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

}
