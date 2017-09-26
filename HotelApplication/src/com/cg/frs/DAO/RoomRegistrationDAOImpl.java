package com.cg.frs.DAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.cg.orb.DTO.Room_Registration;
import com.cg.orb.DbUtil.DbUtil;
import com.cg.orb.exception.HotelException;

public class RoomRegistrationDAOImpl implements IRoomRegistrationDAO {
	
	Logger logger = Logger.getRootLogger();
	public RoomRegistrationDAOImpl() 
	{
		PropertyConfigurator.configure("Log4j.properties");
	}

	int result=0, Room_NO=0;
	
	public int addRoomRegistrationDetails(Room_Registration details) throws SQLException, IOException, HotelException
 {
			Connection conn = null;
			try
			{
			conn = DbUtil.getConnection();

			String insertQuery="Insert into Room_Registration Values(room_SEQ.nextval,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(insertQuery);
			ps.setInt(1,details.getHotel_ID());
			ps.setInt(2,details.getRoom_TYPE());
			ps.setInt(3,details.getRoom_AREA());
			ps.setFloat(4,details.getRENT_AMOUNT());
			ps.setFloat(5,details.getPaid_AMOUNT());
			result=ps.executeUpdate();
			//System.out.println(result+ " row inserted");
			
		
		    String selectQuery ="select room_SEQ.CURRVAL from room_registration";
		    
		    PreparedStatement ps1=conn.prepareStatement(selectQuery);
		    ResultSet rs=ps1.executeQuery();
		   
		    while(rs.next())
		    {
	        Room_NO=rs.getInt(1);
		    }
		    
	        logger.info("Executed successfully");
			}
			
			 catch (IOException e) {
					
					logger.error("Exception Occured " +e.getMessage());
				} 
				
				catch (SQLException e) {
					
					logger.error("Exception Occured  " +e.getMessage());
		     // throw new HotelException(e.getMessage());
					System.out.println(e);
				}
			return Room_NO;  
	}
	

	public ArrayList<Integer> getAllOwnerIds() throws SQLException, IOException, HotelException {
		int id=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		Connection conn = null;
		try
		{
		conn = DbUtil.getConnection();
		
		
		
		String sql="Select hotel_ID from Hotel_owners";
		
		 PreparedStatement ps2=conn.prepareStatement(sql);
		 ResultSet rs=ps2.executeQuery();
		 while(rs.next())
		 {
			id=rs.getInt(1);
			list.add(id);
			 
		 }
		 logger.info("Executed successfully");
		}
		 catch (IOException e) {
				
				logger.error("Exception Occured " +e.getMessage());
			} 
			
			catch (SQLException e) {
				
				logger.error("Exception Occured  " +e.getMessage());
				System.out.println(e.getMessage());
				
			}
		 return list;
	}
		
	
	

}
