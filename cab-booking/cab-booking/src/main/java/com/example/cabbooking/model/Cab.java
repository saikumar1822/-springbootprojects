package com.example.cabbooking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

	private String registrationNumber;
@JsonIgnore
	private String avialbleStatus;

	 @Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	@JsonIgnore
	@OneToMany(mappedBy = "cab", cascade = CascadeType.ALL)
	private List<Booking> bookings;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getAvialbleStatus() {
		return avialbleStatus;
	}

	public void setAvialbleStatus(String avialbleStatus) {
		this.avialbleStatus = avialbleStatus;
	}

	public Long getCabId() {
		return cabId;
	}

	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}

	public String getCabName() {
		return cabName;
	}

	public void setCabName(String cabName) {
		this.cabName = cabName;
	}

	
	

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public static void main(String ...strings) {
		System.out.println(LocalDateTime.now());
	}

}
