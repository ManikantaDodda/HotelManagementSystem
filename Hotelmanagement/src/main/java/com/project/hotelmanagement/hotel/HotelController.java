package com.project.hotelmanagement.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
	@Autowired
	HotelService hotelService;
	@PostMapping("/admin/addnewhotel")
    @PreAuthorize("hasRole('Admin')")
	public Hotel addNewHotel(@RequestBody Hotel hotel) {
		return hotelService.addNewHotel(hotel);
	}
	@GetMapping("/admin/viewallhotels")
	@PreAuthorize("hasRole('Admin')")
	public List<Hotel> ViewAllHotels()
	{
		return hotelService.viewAllHotels();
	}
	@GetMapping("/viewhotel/{hotelId}")
	public Hotel viewHotel(@PathVariable Long hotelId)
	{
		return hotelService.viewHotel(hotelId);
	}

}  
