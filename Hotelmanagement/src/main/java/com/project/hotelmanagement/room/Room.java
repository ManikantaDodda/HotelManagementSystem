package com.project.hotelmanagement.room;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.project.hotelmanagement.booking.Booking;


@Entity
public class Room {
	@Id
	private String roomId;
	//@JsonIgnore
	private Long roomNumber;
	private Long hotel_id;
	//@ColumnDefault("true")
	@Column(columnDefinition = "boolean default false")
	private boolean isBooked;
	//@Column(nullable=false)
	private Long room_price;

	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkIn;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate checkOut;
	
    
   
	public Room() {
		super();
	}
	

	public Room(String roomId, Long hotel_id) {
		super();
		this.roomId = roomId;
		this.hotel_id = hotel_id;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}


	public Long getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Long hotel_id) {
		this.hotel_id = hotel_id;
	}
	
	
	public boolean isBooked() {
		return isBooked;
	}


	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}


	public Long getRoom_price() {
		return room_price;
	}


	public void setRoom_price(Long room_price) {
		this.room_price = room_price;
	}


	public Long getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}


	public LocalDate getCheckIn() {
		return checkIn;
	}


	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}


	public LocalDate getCheckOut() {
		return checkOut;
	}


	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	


}
