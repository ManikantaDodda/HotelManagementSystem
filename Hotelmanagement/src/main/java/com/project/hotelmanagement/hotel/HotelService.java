package com.project.hotelmanagement.hotel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotelmanagement.dao.RoleDao;
import com.project.hotelmanagement.dao.UserDao;
import com.project.hotelmanagement.entity.Role;
import com.project.hotelmanagement.entity.User;
import com.project.hotelmanagement.exception.IllegalNameException;
import com.project.hotelmanagement.service.UserService;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoleDao roleDao;
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
	public Hotel addNewHotel(Hotel hotel) {
		    Hotel hname=hotelRepository.findByHotelName(hotel.getHotelName());
	        Hotel hid = hotelRepository.findByHotelId(hotel.getHotelId());
	        if(hname != null || hid != null)
	        	throw new IllegalNameException("Hotel Name already exists");
	        hotelRepository.save(hotel);
	        
		    Role role = roleDao.findById("HotelAdmin").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        User user=new User();
	        user.setRole(userRoles);
	        String hotelName=hotel.getHotelName();
	        hotelName = hotelName.replaceAll("\\s", "");
		    hotelName = hotelName.substring(0,5);
		    hotelName = hotelName.toUpperCase();
		    Long hotelid= hotel.getHotelId();
		    hotelName=hotelName+hotelid;
	        user.setUserName(hotelName);
	        user.setUserFirstName(hotel.getHotelName());
	        user.setUserLastName(hotel.getHotelName());
	        user.setUserPassword(userService.getEncodedPassword(hotelName));
	        
	        User uu=userDao.findByUserName(hotel.getHotelName());
	       
	        if(uu != null )
	        	throw new IllegalNameException("Hotel Name already exists");
	        userDao.save(user);
	        return hotel;	
	}
	
	public List<Hotel> viewAllHotels() {
		return hotelRepository.findAll();
	}
	
	public Hotel viewHotel(Long hotelId) {
		return hotelRepository.findByHotelId(hotelId);
	}

}
