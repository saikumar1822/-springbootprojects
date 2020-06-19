package com.parking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SpotRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long spotRequesttId;
	
	@OneToOne
	private FreeSpot freeSpot;
	
	@OneToOne
	private Employee employee;
	
	private String status;
	
	private LocalDate startDate;
	
}
