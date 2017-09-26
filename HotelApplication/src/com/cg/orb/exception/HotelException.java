package com.cg.orb.exception;

public class HotelException extends Exception {
	//Hotel_id exception
	int data;
	public HotelException(int data) {
		this.data=data;
	}
	@Override
	public String toString() {
		return "This id = [" + data + "] does not exist in the database";
	}
	
	
	//SQL exception
	public HotelException(String msg) {
		super(msg);
	}	
}
