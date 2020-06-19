package com.example.cabbooking.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BookingSearchDto {
	private long userId;
	@Temporal(TemporalType.TIMESTAMP)

	 private Date bookingTime;


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	 public Date getBookingTime() {

	 return bookingTime;

	 }



	 public void setBookingTime(Date bookingTime) {

	 this.bookingTime = bookingTime;

	 }



}
