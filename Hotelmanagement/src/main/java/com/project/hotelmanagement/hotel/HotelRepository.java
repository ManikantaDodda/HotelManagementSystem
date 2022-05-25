package com.project.hotelmanagement.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface  HotelRepository  extends JpaRepository<Hotel, Long>{
	Hotel findByHotelId(Long hotelId);
	Hotel findByHotelName(String hotelName);

}
