package com.project.hotelmanagement.booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Booking, Long> {
	

}
