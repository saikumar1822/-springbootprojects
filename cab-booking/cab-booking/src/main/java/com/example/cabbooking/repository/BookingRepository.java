package com.example.cabbooking.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cabbooking.model.Booking;
import com.example.cabbooking.model.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	Booking findBookingByBookingIdAndUser(long bookingId, User user);

	List<Booking> findByUserAndBookingTimeContaining(User user, Date bookingTime);

	List<Booking> findByUserAndBookingTimeGreaterThan(User user, Date bookingTime);

	List<Booking> findByBookingTimeGreaterThan(Date bookingTime);

	List<Booking> findBookingByUserAndBookingTimeGreaterThan(User user, Date bookingTime);


}
