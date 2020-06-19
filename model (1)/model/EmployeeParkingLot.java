package com.parking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmployeeParkingLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@OneToOne
	private ParkingLot parkingLot;
	
	@OneToOne
	private Employee employee;
	
	private String status;
	
	
}
