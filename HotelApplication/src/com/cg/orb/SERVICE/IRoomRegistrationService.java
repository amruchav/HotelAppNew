package com.cg.orb.SERVICE;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.orb.DTO.Room_Registration;
import com.cg.orb.exception.HotelException;

public interface IRoomRegistrationService {
	
	public int addRoomRegistrationDetails(Room_Registration details) throws SQLException, IOException, HotelException;
	public ArrayList<Integer> getAllOwnerIds() throws SQLException, IOException, HotelException;
	
	public boolean validatehotel_ID(int hotel_ID,ArrayList<Integer> list) throws HotelException;
	public boolean validateAmount(float RENT_AMOUNT,float Paid_AMOUNT);
}
