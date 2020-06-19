package com.parking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class EmployeeParking {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	

	@OneToOne()
	private Employee employee;
	

	@OneToOne()
	private ParkingLot  parkingLot;
	
	

}
