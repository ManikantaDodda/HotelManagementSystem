package com.project.hotelmanagement.hotel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.project.hotelmanagement.booking.Booking;
import com.project.hotelmanagement.room.Room;


@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hotelId;
	@Column(unique=true)
	private String hotelName;
	private String area;
	private String state;
	@OneToMany(mappedBy = "hotel_id",cascade = CascadeType.ALL)
	//@JoinColumn(name = "hotel_id")
	private List<Room> rooms;
	@OneToMany(mappedBy = "hotel_id",cascade = CascadeType.ALL)
	//@JoinColumn(name="hotel_id")
	private List<Booking> bookings;
	
	public Hotel() {
		super();
	}
	public Hotel(String hotelName, String area) {
		super();
		this.hotelName = hotelName;
		this.area = area;
	}
	
	
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	

}
