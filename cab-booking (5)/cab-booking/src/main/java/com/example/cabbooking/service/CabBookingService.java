package com.example.cabbooking.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.dto.BookingDto;
import com.example.cabbooking.dto.BookingSearchDto;
import com.example.cabbooking.dto.BookingServiceDto;
import com.example.cabbooking.dto.CancelDto;
import com.example.cabbooking.dto.ResponseDto;
import com.example.cabbooking.exceptions.BookingNotpossibleException;
import com.example.cabbooking.exceptions.CabBookingHistoryNotFound;
import com.example.cabbooking.exceptions.CabNotFoundException;
import com.example.cabbooking.exceptions.CancelNotpossibleException;
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

	public ResponseDto cancelBooking(CancelDto cancelDto) throws CabNotFoundException, UserNotFoundException, CancelNotpossibleException {
		Booking booking = new Booking();
		User user =new User();
		user=userRepository.findById(cancelDto.getUserId()).orElseThrow(()->new UserNotFoundException("user with given details not found"));
		
		booking = bookingRepository.findBookingByBookingIdAndUser(cancelDto.getBookingId(),user);
		if(booking.getBookingStatus().equalsIgnoreCase("booked")) {
		int booktime = booking.getBookingTime().getHour();
		Cab cab=new Cab();
		cab=cabRepository.findById(booking.getCab().getCabId()).orElseThrow(()->new CabNotFoundException("cab with given details not found"));
		int cabtime=cab.getDateTime().getHour();
		if((cabtime-booktime)>1) {
		booking.setBookingStatus("cancelled");
		bookingRepository.save(booking);
		cab.setAvailableStatus("available");
		cabRepository.save(cab);
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
			response.setMessage("Cancellation cannot be done");
			return response;
		}
		}
		else {
			throw new CancelNotpossibleException(" cancellation already done");
		}
	}

	public List<BookingServiceDto> getHistory(BookingSearchDto bookingSearchDto) throws CabBookingHistoryNotFound, ParseException, UserNotFoundException {
				 User user = userRepository.findById(bookingSearchDto.getUserId()).orElseThrow(()->new UserNotFoundException("user with given details not found"));
				 List<BookingServiceDto> list=new ArrayList<>();
				 List<Booking> bookings= bookingRepository.findBookingByUser(user);
				 if(bookings.isEmpty()) {
					 throw new CabBookingHistoryNotFound();
				 }
				 else {
					 BookingServiceDto bookingServiceDto = null;
						for (Booking booking : bookings) {
							bookingServiceDto = new BookingServiceDto();
								if(booking.getBookingTime().getMonthValue()==bookingSearchDto.getMonth()) {
									if(booking.getBookingTime().getYear()==bookingSearchDto.getYear()){
										BeanUtils.copyProperties(booking, bookingServiceDto);
										list.add(bookingServiceDto);
									}
								}
							}
							return list;
						}
						
				 } 
				
	 
	 public void bookCab(BookingDto bookingDto)	throws CabNotFoundException, UserNotFoundException, BookingNotpossibleException {
		Booking booking = new Booking();
		LocalDateTime startLocalDateTime = LocalDateTime.now();
		booking.setBookingTime(startLocalDateTime);	
		User user = userRepository.findById(bookingDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("user with given id not found"));
		booking.setUser(user);
		Cab cab = cabRepository.findById(bookingDto.getCabId()).orElseThrow(()->new CabNotFoundException("cab id not found"));
		booking.setCab(cab);
		if (cab.getAvailableStatus().equalsIgnoreCase("available")) {
			LocalDateTime d2 = cab.getDateTime();
			System.out.println(d2);
			int cabtime = cab.getDateTime().getHour();
			if (d2.compareTo(startLocalDateTime) < 0) {
				int localtime = startLocalDateTime.getHour();
				int date=startLocalDateTime.getDayOfMonth();
				int cabdate=cab.getDateTime().getDayOfMonth();
				if(cabdate>=date) {
				int differnece = cabtime - localtime;
				System.out.println(localtime);

				if (differnece > 2) {
					booking.setCab(cab);
					booking.setBookingStatus("booked");
					bookingRepository.save(booking);
				} else {
					throw new BookingNotpossibleException(" time is less");
				}
				}
				else {
					throw new BookingNotpossibleException("date not correctly matched");
				}
			} else {
				cab.setAvailableStatus("not available");
				booking.setCab(cab);
				booking.setBookingStatus("booked");
				bookingRepository.save(booking);
			}
		} else {
			throw new BookingNotpossibleException(" status not available");
		}

	}
	
	
}
