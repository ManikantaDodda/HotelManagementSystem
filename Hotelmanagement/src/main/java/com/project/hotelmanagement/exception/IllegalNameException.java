package com.project.hotelmanagement.exception;

public class IllegalNameException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public IllegalNameException(String msg) {
		super(msg);
	}
}
