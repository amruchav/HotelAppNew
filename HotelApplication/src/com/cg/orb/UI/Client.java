package com.cg.orb.UI;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.cg.orb.DTO.Room_Registration;
import com.cg.orb.SERVICE.RoomRegistrationServiceImpl;
import com.cg.orb.exception.HotelException;

public class Client {
	
	static Scanner sc;
	static Room_Registration details;
	static RoomRegistrationServiceImpl service;
	static int choice=0;
	
	
	
	public static void main(String[] args) throws SQLException, IOException, HotelException  {
		
		
		
		sc=new Scanner(System.in);
		System.out.println("Hotel Application");
		System.out.println("******************");
		System.out.println("1.Enter Purchase Details");
		System.out.println("2.Exit");
		System.out.println("\n");
		while(true)
			{
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addRoomRegistrationDetails();
					break;
			case 2:System.out.println("Thank you");
				   System.exit(0);
				   	break;
		}
	  }
	}



	private static void addRoomRegistrationDetails() throws SQLException, IOException, HotelException {
		
	     int res=0;
	    service=new RoomRegistrationServiceImpl();
	    sc=new Scanner(System.in);
	    ArrayList<Integer> list;
		try {
			list = service.getAllOwnerIds();
		
	    System.out.println("Existing HotelOwner IDS Are:-" +list);
	    System.out.println("Please enter your hotel owner id from above list: ");
		int hotel_ID=sc.nextInt();
		if(service.validatehotel_ID(hotel_ID,list))
		{
		System.out.println("Select  room type Type (1-1AC, 2-2NON-AC): ");
		int room_TYPE=sc.nextInt();
		
		System.out.println("Enter room area in sq. ft.:  ");
		int room_AREA=sc.nextInt();
		
		System.out.println("Enter desired rent amount Rs: ");
		float RENT_AMOUNT=sc.nextFloat();
		
		System.out.println("Enter desired paid amount Rs: ");
		float Paid_AMOUNT=sc.nextFloat();
		
		if(service.validateAmount(RENT_AMOUNT,Paid_AMOUNT))
		{
		details=new Room_Registration(hotel_ID, room_TYPE, room_AREA, RENT_AMOUNT, Paid_AMOUNT);
		service=new RoomRegistrationServiceImpl();
		
		res = service.addRoomRegistrationDetails(details);
		if(res > 0)
		{
		System.out.println("Room successfully registered. Room no:" +res);
		}
		}
		}
		} catch (HotelException e) {
			
			//throw new HotelException(e.getMessage());
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println("Exception Occured" +e.getMessage());
		}
	}
	}