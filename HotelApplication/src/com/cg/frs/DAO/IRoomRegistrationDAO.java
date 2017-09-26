package com.cg.frs.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.orb.DTO.Room_Registration;
import com.cg.orb.exception.HotelException;

public interface IRoomRegistrationDAO {

	public int addRoomRegistrationDetails(Room_Registration details) throws SQLException, IOException, HotelException;

	public ArrayList<Integer> getAllOwnerIds() throws SQLException, IOException, HotelException;

}
