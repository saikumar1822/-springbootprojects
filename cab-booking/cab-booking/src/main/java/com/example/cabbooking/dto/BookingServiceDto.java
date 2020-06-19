package com.example.cabbooking.dto;

import java.util.List;

import com.example.cabbooking.model.Booking;

public class BookingServiceDto {
	private List<Booking> bookings;
	
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	

}
