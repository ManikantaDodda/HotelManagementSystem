package com.project.hotelmanagement.booking;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelmanagement.exception.IllegalNameException;
import com.project.hotelmanagement.hotel.Hotel;
import com.project.hotelmanagement.hotel.HotelRepository;
import com.project.hotelmanagement.payment.Payment;
import com.project.hotelmanagement.payment.PaymentRepository;
import com.project.hotelmanagement.room.Room;
import com.project.hotelmanagement.room.RoomRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	@Autowired
	RoomRepository roomRepo;
	@Autowired
	HotelRepository hotelRepo;
	@Autowired
	PaymentRepository paymentRepo;
	
	public Booking book(Booking booking) {
		Room findroom = roomRepo.findByRoomId(booking.getRoom_id());
		Hotel findhotel = hotelRepo.findByHotelId(booking.getHotel_id());
		if(findroom==null || findhotel==null) {
			throw new IllegalNameException("Room Id or Hotel Id not found");
		}
		if(findroom.isBooked()== true) {
			throw new IllegalNameException("This Room already Booked! Try different ones");
		}
		Booking booked=bookRepo.save(booking);
		
		Payment addpayment= new Payment();
		Random random= new Random();  
		addpayment.setPayment_id(100L);
		addpayment.setUser_name(booking.getUser_name());
		addpayment.setBook_id(booking.getBookId());
		addpayment.setAmount(findroom.getRoom_price());
		addpayment.setPayment_id(booking.getBookId());
		paymentRepo.save(addpayment);
		findroom.setBooked(true);
		roomRepo.save(findroom);
		return booked;
	}

}
