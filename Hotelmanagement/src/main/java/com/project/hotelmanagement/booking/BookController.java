package com.project.hotelmanagement.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	@PostMapping("/book")
	public Booking book(@RequestBody Booking booking) {
		
		return bookService.book(booking);
	}


}
