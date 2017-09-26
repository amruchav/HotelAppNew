package com.cg.orb.DTO;

public class Room_Registration {
	
	private String Room_NO;  
	private int hotel_ID; 
	private int room_TYPE;
	private int room_AREA;
	private float RENT_AMOUNT;
	private float Paid_AMOUNT;
	

	public Room_Registration() {
		
		
	}


	public Room_Registration(int hotel_ID, int room_TYPE, int room_AREA,
			float rENT_AMOUNT, float paid_AMOUNT) {
		super();
		this.hotel_ID = hotel_ID;
		this.room_TYPE = room_TYPE;
		this.room_AREA = room_AREA;
		RENT_AMOUNT = rENT_AMOUNT;
		Paid_AMOUNT = paid_AMOUNT;
	}


	public String getRoom_NO() {
		return Room_NO;
	}


	public void setRoom_NO(String room_NO) {
		Room_NO = room_NO;
	}


	public int getHotel_ID() {
		return hotel_ID;
	}


	public void setHotel_ID(int hotel_ID) {
		this.hotel_ID = hotel_ID;
	}


	public int getRoom_TYPE() {
		return room_TYPE;
	}


	public void setRoom_TYPE(int room_TYPE) {
		this.room_TYPE = room_TYPE;
	}


	public int getRoom_AREA() {
		return room_AREA;
	}


	public void setRoom_AREA(int room_AREA) {
		this.room_AREA = room_AREA;
	}


	public float getRENT_AMOUNT() {
		return RENT_AMOUNT;
	}


	public void setRENT_AMOUNT(float rENT_AMOUNT) {
		RENT_AMOUNT = rENT_AMOUNT;
	}


	public float getPaid_AMOUNT() {
		return Paid_AMOUNT;
	}


	public void setPaid_AMOUNT(float paid_AMOUNT) {
		Paid_AMOUNT = paid_AMOUNT;
	}
}
