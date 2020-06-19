package com.example.cabbooking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cabId;
	
	private String cabName;
	
    @Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp ;

  
	@OneToMany(mappedBy = "cab", cascade = CascadeType.ALL)
	private List<Booking> bookings;

	
}
