package com.cg.orb.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.frs.DAO.IRoomRegistrationDAO;
import com.cg.frs.DAO.RoomRegistrationDAOImpl;
import com.cg.orb.DTO.Room_Registration;
import com.cg.orb.exception.HotelException;

public class TestCase {
	
	static IRoomRegistrationDAO dao=null;
	static Room_Registration bean=null;
	
	@BeforeClass
	public static void initialize() throws HotelException
	{
		
		dao=new RoomRegistrationDAOImpl();
		bean=new Room_Registration();
	}
	
	@Test
	public void test() {
		
		bean.setHotel_ID(1);
		//bean.setRoom_NO("1000");
		bean.setRoom_TYPE(1);
		bean.setRoom_AREA(200);
		bean.setRENT_AMOUNT(9000);
		bean.setPaid_AMOUNT(5000);	
	}
	
	@Test

	public void testAddDetails()
	{
			try {
				assertNotNull(dao.addRoomRegistrationDetails(bean));
			} catch (SQLException | IOException | HotelException e) {
				System.out.println("EXCEPTION OCCURED");
			}
		}
	
	
	@Test
	public void getDetails() 
	{
			try {
				assertNotNull(dao.getAllOwnerIds());
			} catch (SQLException | IOException | HotelException e) {
				System.out.println("EXCEPTION OCCURED");
			}
		}	
}
