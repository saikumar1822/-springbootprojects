package com.example.cabbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cabbooking.dto.BookingDto;
import com.example.cabbooking.dto.BookingSearchDto;
import com.example.cabbooking.dto.BookingServiceDto;
import com.example.cabbooking.dto.CancelDto;
import com.example.cabbooking.dto.ResponseDto;
import com.example.cabbooking.dto.ResponseDto1;
import com.example.cabbooking.exceptions.BookingNotpossibleException;
import com.example.cabbooking.exceptions.CabBookingHistoryNotFound;
import com.example.cabbooking.exceptions.CabNotFoundException;
import com.example.cabbooking.exceptions.CancelNotpossibleException;
import com.example.cabbooking.exceptions.UserNotFoundException;
import com.example.cabbooking.service.CabBookingService;
import com.sun.el.parser.ParseException;

@RestController
public class CabBookingController {

	@Autowired
	CabBookingService cabBookingService;
	@PostMapping("/booking")
	public ResponseEntity<ResponseDto1> cabBooking(@RequestBody BookingDto bookingDto) throws CabNotFoundException, UserNotFoundException, BookingNotpossibleException{
	cabBookingService.bookCab(bookingDto);
	ResponseDto1 responseDto=new ResponseDto1();
	responseDto.setMessage("booking is done");
		return new ResponseEntity<ResponseDto1>(responseDto, HttpStatus.OK);
	}
	@DeleteMapping("/cancelBooking")
	public ResponseDto cancelBooking(@RequestBody CancelDto cancelDto) throws CabNotFoundException, UserNotFoundException, CancelNotpossibleException {
		ResponseDto response;
		response=cabBookingService.cancelBooking(cancelDto);
		return response;
	}
	@PostMapping("/cabhistory")
	public List<BookingServiceDto> history(@RequestBody BookingSearchDto bookingSearchDto ) throws UserNotFoundException, CabBookingHistoryNotFound, ParseException{
		return cabBookingService.getHistory(bookingSearchDto);
	}

}
