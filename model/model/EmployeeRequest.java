package com.parking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmployeeRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;

	@OneToOne()
	private Employee employee;

	private LocalDate startDate;

	private LocalDate endDate;

}
