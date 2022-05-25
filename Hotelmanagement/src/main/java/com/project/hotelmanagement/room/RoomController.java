package com.project.hotelmanagement.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoomController {
	@Autowired 
	RoomService roomService;
	
	@PostMapping("/addnewroom")
    @PreAuthorize("hasRole('Admin') or hasRole('HotelAdmin')")
	public Room addNewRoom(@RequestBody Room room) {
		return roomService.addNewRoom(room);
	}
	@PutMapping("/updateroomprice/{roomId}")
    @PreAuthorize("hasRole('Admin') or hasRole('HotelAdmin')")
	public Room updateRoomPrice(@PathVariable String roomId,@RequestBody Room room) {
		return roomService.updateRoomPrice(roomId,room);
	}

}
