package com.example.cabbooking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.dto.BookingDto;
import com.example.cabbooking.exceptions.BookingNotpossibleException;
import com.example.cabbooking.exceptions.CabNotFoundException;
import com.example.cabbooking.exceptions.UserIdNotFound;
import com.example.cabbooking.model.Booking;
import com.example.cabbooking.model.Cab;
import com.example.cabbooking.model.User;
import com.example.cabbooking.repository.BookingRepository;
import com.example.cabbooking.repository.CabRepository;
import com.example.cabbooking.repository.UserRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CabRepository cabRepository;

	public void bookCab(BookingDto bookingDto)
			throws CabNotFoundException, UserIdNotFound, BookingNotpossibleException {
		Booking booking = new Booking();
		booking.setBookingTime(new Date());
		User user = userRepository.findById(bookingDto.getUserId())
				.orElseThrow(() -> new UserIdNotFound("user with given id not found"));
		booking.setUser(user);
		Cab cab = cabRepository.findById(bookingDto.getCabId())
				.orElseThrow(() -> new CabNotFoundException("user with given id not found"));
		booking.setCab(cab);
		if (cab.getAvialbleStatus().equalsIgnoreCase("availble")) {
			Date d2 = cab.getTimeStamp();
			System.out.println(cab.getTimeStamp());
			long cabtime = cab.getTimeStamp().getHours();
			Date d = new Date();
			if (d2.compareTo(d) < 0) {
				long localtime = d.getHours();
				long differnece = cabtime - localtime;
				System.out.println(localtime);

				if (differnece > 2) {
					booking.setCab(cab);
					booking.setBookingStatus("booked");
					bookingRepository.save(booking);
				} else {
					throw new BookingNotpossibleException(" time is less");
				}
			} else {
				cab.setAvialbleStatus("not available");
				booking.setCab(cab);
				booking.setBookingStatus("booked");
				bookingRepository.save(booking);
			}
		} else {
			throw new BookingNotpossibleException(" status not available");
		}

	}
}
