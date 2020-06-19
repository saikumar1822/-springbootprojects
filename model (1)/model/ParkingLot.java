package com.parking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class ParkingLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long parkingLotId;
	
	private String spot;
	
	private String description;
	
	
	
	
	
	

}
