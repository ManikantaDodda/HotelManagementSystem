package com.project.hotelmanagement.room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelmanagement.exception.IllegalNameException;
import com.project.hotelmanagement.exception.NotFoundException;
import com.project.hotelmanagement.hotel.Hotel;
import com.project.hotelmanagement.hotel.HotelRepository;

@Service
public class RoomService {
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	HotelRepository hotelRepository;

	public Room addNewRoom(Room room) {
		Room newRoom = new Room();
		Long hotelId=room.getHotel_id();
		Hotel hid= hotelRepository.findByHotelId(hotelId);

		if(hid==null)
			throw new NotFoundException("Hotel Id not found");
		String hotelName=hid.getHotelName();
	    hotelName = hotelName.replaceAll("\\s", "");
	    hotelName = hotelName.substring(0,3);
	    hotelName = hotelName.toUpperCase();
		Long roomId = room.getRoomNumber();
		room.setRoomNumber(roomId);
	    if(roomId==null || roomId==0) 
	    	throw new IllegalNameException("Please give room number");
	    if(room.getRoom_price()==null || room.getRoom_price()==0)
	    	throw new IllegalNameException("Room price must be give");
		String concatRoomId=hotelName+hotelId+"-"+roomId;
		newRoom.setRoomId(concatRoomId);
		newRoom.setHotel_id(room.getHotel_id());
		newRoom.setRoomNumber(roomId);
		newRoom.setRoom_price(room.getRoom_price());
		
		Room rid=roomRepository.findByRoomId(concatRoomId);
		if(rid != null)
			throw new IllegalNameException("Room Id already found ");
		
		return roomRepository.save(newRoom);
		
	}

	public Room updateRoomPrice(String roomId,Room room) {
		Room findroom=roomRepository.findByRoomId(roomId);
		if(findroom == null) 
			throw new IllegalNameException("Room Id not found");
		findroom.setRoom_price(room.getRoom_price());
		roomRepository.updatePrice(room.getRoom_price(), roomId);
		return roomRepository.findByRoomId(roomId);
	}

}
