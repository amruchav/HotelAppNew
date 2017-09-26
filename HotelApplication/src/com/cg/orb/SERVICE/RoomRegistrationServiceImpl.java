package com.cg.orb.SERVICE;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.frs.DAO.IRoomRegistrationDAO;
import com.cg.frs.DAO.RoomRegistrationDAOImpl;
import com.cg.orb.DTO.Room_Registration;
import com.cg.orb.exception.HotelException;

public class RoomRegistrationServiceImpl implements IRoomRegistrationService {
	
	IRoomRegistrationDAO dao=null;

	public int addRoomRegistrationDetails(Room_Registration details) throws SQLException, IOException, HotelException {
		
		dao =new RoomRegistrationDAOImpl();
		return dao.addRoomRegistrationDetails(details);
		
	}
	
	public ArrayList<Integer> getAllOwnerIds() throws SQLException, IOException, HotelException {

		dao =new RoomRegistrationDAOImpl();
		return dao.getAllOwnerIds();
		
		
	}

	
	public boolean validatehotel_ID(int hotel_ID,ArrayList<Integer> list) throws HotelException
	{  
		int c=0;
	  for(Integer m:list){
		  if(m==hotel_ID){
			  c=1;
			  break;
		  }	  
	}
	  if(c==0){
		  
		  throw new HotelException(hotel_ID);
		  //System.out.println("hotel owner  id does not exists");
		  //return false;
	  }
	  else
		  return true;
	}
	
	
	public boolean validateAmount(float RENT_AMOUNT,float Paid_AMOUNT)
	{
		
		if(Paid_AMOUNT > RENT_AMOUNT )
		{
			return true;
		}
		else
		{
			System.out.println("You are paying less amount");
			return false;
		}
	}

	

	

	

}
