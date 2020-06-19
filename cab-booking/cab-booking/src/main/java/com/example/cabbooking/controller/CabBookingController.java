package com.example.cabbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabbooking.dto.BookingSearchDto;
import com.example.cabbooking.dto.BookingServiceDto;
import com.example.cabbooking.dto.CancelDto;
import com.example.cabbooking.dto.ResponseDto;
import com.example.cabbooking.exceptions.CabBookingHistoryNotFound;
import com.example.cabbooking.exceptions.CabNotFoundException;
import com.example.cabbooking.exceptions.UserNotFoundException;
import com.example.cabbooking.model.Booking;
import com.example.cabbooking.model.Cab;
import com.example.cabbooking.service.CabBookingService;
import com.sun.el.parser.ParseException;

@RestController
public class CabBookingController {

	@Autowired
	CabBookingService cabBookingService;
	
	@PostMapping("/cab")
	public void createcab(@RequestBody Cab cab) {
		cabBookingService.save(cab);
	}
	@PostMapping("/cabbooking")
	public void createbooking(@RequestBody Booking booking) {
		cabBookingService.saveBooking(booking);
	}
	
	@DeleteMapping("/cancelBooking")
	public ResponseDto cancelBooking(@RequestBody CancelDto cancelDto) throws CabNotFoundException, UserNotFoundException {
		ResponseDto response;
		response=cabBookingService.cancelBooking(cancelDto);
		return response;
	}
	@PostMapping("/cabhistory")
	public BookingServiceDto history(@RequestBody BookingSearchDto bookingSearchDto ) throws UserNotFoundException, CabBookingHistoryNotFound, ParseException{
		return cabBookingService.getHistory(bookingSearchDto);
	}

}
