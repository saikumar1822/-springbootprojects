package com.example.cabbooking.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.dto.BookingSearchDto;
import com.example.cabbooking.dto.BookingServiceDto;
import com.example.cabbooking.dto.CancelDto;
import com.example.cabbooking.dto.ResponseDto;
import com.example.cabbooking.dto.ResponseDto1;
import com.example.cabbooking.exceptions.CabBookingHistoryNotFound;
import com.example.cabbooking.exceptions.CabNotFoundException;
import com.example.cabbooking.exceptions.UserNotFoundException;
import com.example.cabbooking.model.Booking;
import com.example.cabbooking.model.Cab;
import com.example.cabbooking.model.User;
import com.example.cabbooking.repository.BookingRepository;
import com.example.cabbooking.repository.CabRepository;
import com.example.cabbooking.repository.UserRepository;
import com.sun.el.parser.ParseException;

@Service
public class CabBookingService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CabRepository cabRepository;
	
	@Autowired
	BookingRepository bookingRepository;

	public ResponseDto cancelBooking(CancelDto cancelDto) throws CabNotFoundException, UserNotFoundException {
		Booking booking = new Booking();
		User user =new User();
		user=userRepository.findById(cancelDto.getUserId()).orElseThrow(()->new UserNotFoundException("user with given details not found"));
		
		booking = bookingRepository.findBookingByBookingIdAndUser(cancelDto.getBookingId(),user);
		Timestamp timestamp1 = new Timestamp(booking.getBookingTime().getTime());
		Cab cab=new Cab();
		cab=cabRepository.findById(booking.getCab().getCabId()).orElseThrow(()->new CabNotFoundException("cab with given details not found"));
		Timestamp timestamp2 = new Timestamp(cab.getTimeStamp().getTime());
		long milliseconds = timestamp2.getTime() - timestamp1.getTime();
		int seconds = (int) milliseconds / 1000;
		int hours = seconds / 3600;
		System.out.println(timestamp1+" /n"+timestamp2+"/n"+hours);
		if(hours>1) {
		booking.setBookingStatus("cancelled");
		bookingRepository.save(booking);
		ResponseDto response=new ResponseDto();
		response.setBookIngId(booking.getBookingId());
		response.setCabId(booking.getCab().getCabId());
		response.setUserId(booking.getUser().getUserId());
		response.setMessage("booking cancelled successfully");
		return response;
		}
		else {
			ResponseDto response=new ResponseDto();
			response.setBookIngId(booking.getBookingId());
			response.setCabId(booking.getCab().getCabId());
			response.setUserId(booking.getUser().getUserId());
			response.setMessage("booking cancel not successfull");
			return response;
			
		}
	}

	public void save(Cab cab) {
		Timestamp timestamp2 = new Timestamp(cab.getTimeStamp().getTime());
		long milliseconds = timestamp2.getTime();
		int seconds = (int) milliseconds / 1000;
		int hours = seconds / 3600;
		cabRepository.save(cab);
		
		
	}

	public void saveBooking(Booking booking) {
		bookingRepository.save(booking);
		
	}
		 public BookingServiceDto getHistory(BookingSearchDto bsd) throws CabBookingHistoryNotFound, ParseException, UserNotFoundException {
			 User user = userRepository.findById(bsd.getUserId()).orElseThrow(()->new UserNotFoundException("user with given details not found"));
		 List<Booking> bookings= bookingRepository.findBookingByUserAndBookingTimeGreaterThan(user,bsd.getBookingTime());
		 if(bookings.isEmpty()) {
		  throw new CabBookingHistoryNotFound();
		 }
		 BookingServiceDto bookingDto=new BookingServiceDto();

		 bookingDto.setBookings(bookings);;

		 return bookingDto;

		 }
	
}
