package com.example.cabbooking.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
	private Long bookingId;

     @Temporal(TemporalType.TIMESTAMP)
	 private Date bookingTime;
	 
	@ManyToOne(cascade = CascadeType.MERGE)
	private Cab cab;

	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;

}
