package com.example.cabbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabbooking.dto.BookingDto;
import com.example.cabbooking.dto.ResponseDto1;
import com.example.cabbooking.exceptions.BookingNotpossibleException;
import com.example.cabbooking.exceptions.CabNotFoundException;
import com.example.cabbooking.exceptions.UserIdNotFound;
import com.example.cabbooking.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/booking")
	public ResponseEntity<ResponseDto1> cabBooking(@RequestBody BookingDto bookingDto) throws CabNotFoundException, UserIdNotFound, BookingNotpossibleException{
	bookingService.bookCab(bookingDto);
	ResponseDto1 responseDto=new ResponseDto1();
	responseDto.setMessage("booking is done");
		return new ResponseEntity<ResponseDto1>(responseDto, HttpStatus.OK);
	}
	
	
}
