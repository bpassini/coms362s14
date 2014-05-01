package edu.iastate.cs362.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelView {
	public static void main(String[] args) {
		
		System.out.println("\t\t Hotel\n");
		System.out.println("What would you like to do? \n"+
			    " 1. Create a Hotel\n"+
			    " 2. Create a Room for a specific Hotel\n"+
			    " 3. Create a Room Invoice for a specific Hotel\n" +
			    " 4. Create a Room Reservation for a specific Hotel\n" +
			    " 5. Update a Hotel\n" +
			    " 6. Check out of a room\n" +
			    " 7. Check into a room\n" +
			    " 8. Update a Room Invoice\n" +
			    " 9. Update a Room Reservation\n" +
			    "10. Search for Rooms\n" + 
			    "11. Check for Room Availability\n" +
			    "12. Exit");
		
		Scanner in = new Scanner(System.in);
		boolean returnCode = false;
		while(true) {
			int inputNum = 0;
			if(in.hasNextLine()) {
				inputNum = Integer.parseInt(in.nextLine().trim());
				if(inputNum < 0 || inputNum > 12) {
					System.out.println("Input invalid, please try again.");
					continue;
				}
			}
			if(inputNum == 1)
				returnCode = createHotel();
			else if(inputNum == 2)
				returnCode = addRoom();
			else if(inputNum == 3)
				returnCode = createRoomInvoice();
			else if(inputNum == 4)
				returnCode = createRoomReservation();
			else if(inputNum == 5)
				returnCode = updateHotel();
			else if(inputNum == 6)
				returnCode = checkOutOfRoom();
			else if(inputNum == 7)
				returnCode = checkIntoRoom();
			else if(inputNum == 8)
				returnCode = updateRoomInvoice();
			else if(inputNum == 9)
				returnCode = updateRoomReservation();
			else if(inputNum == 10)
				returnCode = searchRooms();
			else if(inputNum == 11)
				returnCode = checkRoomAvailability();
			else 
				break;
			
			if(!returnCode) {
				System.out.println("Operation failed, please try again.");
			}
			else {
				System.out.println("Operation succeeded!");
			}
			
			System.out.println("What would you like to do? \n"+
				    " 1. Create a Hotel\n"+
				    " 2. Create a Room for a specific Hotel\n"+
				    " 3. Create a Room Invoice for a specific Hotel\n" +
				    " 4. Create a Room Reservation for a specific Hotel\n" +
				    " 5. Update a Hotel\n" +
				    " 6. Check out of a room\n" +
				    " 7. Check into a room\n" +
				    " 8. Update a Room Invoice\n" +
				    " 9. Update a Room Reservation\n" +
				    "10. Search for Rooms\n" + 
				    "11. Check for Room Availability\n" +
				    "12. Exit");
		}
	}

	private static boolean createHotel() {
		Scanner in = new Scanner(System.in);
		String id, name = id = "";
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			id = in.nextLine().trim();
		System.out.println("Enter hotel name");
		if(in.hasNextLine())
			name = in.nextLine().trim();
		
		return new HotelController().createHotel(id, name);
	}
	
	private static boolean addRoom() {
		Scanner in = new Scanner(System.in);
		String hid, descr = hid = "";
		int occup, rmid = occup = 0;
		ArrayList<String> beds = new ArrayList<String>();
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
				hid = in.nextLine().trim();
		System.out.println("Enter room id (Integer)");
		if(in.hasNextLine())
			rmid = Integer.parseInt(in.nextLine().trim());
		System.out.println("Enter room occupancy");
		if(in.hasNextLine())
			occup = Integer.parseInt(in.nextLine().trim());
		
		int numBeds = 0;
		System.out.println("Enter the number of beds in this room");
		if(in.hasNextLine())
			numBeds = Integer.parseInt(in.nextLine().trim());
		for(int i = 1; i <= numBeds; i++) {
			int choice = 0;
			System.out.println("What is the type of bed " + i);
			System.out.println("\t1. King\n\t2. Queen\n\t3. Full");
			if(in.hasNextLine())
				choice = Integer.parseInt(in.nextLine().trim());
			if(choice == 1)
				beds.add("King");
			else if(choice == 2)
				beds.add("Queen");
			else if(choice == 3)
				beds.add("Full");
		}
		
		System.out.println("Enter a room description");
		if(in.hasNextLine())
			descr = in.nextLine().trim();
		return new HotelController().addRoom(hid, beds, occup, descr, rmid);
	}
	
	private static boolean createRoomInvoice() {
		Scanner in = new Scanner(System.in);
		String hId, iId, notes = iId = hId = "";
		int rmId = 0;
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		System.out.println("Enter new room invoice id");
		if(in.hasNextLine())
			iId = in.nextLine().trim();
		System.out.println("Enter id for corresponding room");
		if(in.hasNextLine())
			rmId = Integer.parseInt(in.nextLine().trim());
		System.out.println("Enter invoice notes");
		if(in.hasNextLine())
			notes = in.nextLine().trim();
		return new HotelController().createRoomInvoice(hId, rmId, iId, notes);
	}
	
	private static boolean createRoomReservation() {
		Scanner in = new Scanner(System.in);
		String hId, rrId, fname, lname, start, end = start = lname = fname = hId = rrId = "";
		int cId, rmid = cId = -1;
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		System.out.println("Enter room reservation id");
		if(in.hasNextLine())
			rrId = in.nextLine().trim();
		System.out.println("Enter room id");
		if(in.hasNextLine())
			rmid = Integer.parseInt(in.nextLine().trim());
		System.out.println("Enter customer id (Integer)");
		if(in.hasNextLine())
			cId = Integer.parseInt(in.nextLine().trim());
		System.out.println("Enter customer's first name");
		if(in.hasNextLine())
			fname = in.nextLine().trim();
		System.out.println("Enter customer's last name");
		if(in.hasNextLine())
			lname = in.nextLine().trim();
		System.out.println("Enter start date (MM/dd/yyyy)");
		if(in.hasNextLine())
			start = in.nextLine().trim();
		System.out.println("Enter end date (MM/dd/yyyy)");
		if(in.hasNextLine())
			end = in.nextLine().trim();

		return new HotelController().createRoomReservation(rrId, hId, start, end, new Customer(cId, fname, lname), rmid);
	}

	private static boolean updateHotel() {
		Scanner in = new Scanner(System.in);
		String hId, name = hId = "";
		int flag = -1;
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		
		System.out.println("What would you like to update?\n" +
				"0. Name");		
		if(in.hasNextLine())
			flag = Integer.parseInt(in.nextLine().trim());
		
		if(flag == 0) {
			System.out.println("Enter the new name.");
			if(in.hasNextLine())
				name = in.nextLine().trim();
			return new HotelController().updateHotel(hId, HotelInterface.UPDATE_NAME, name);
		}
		else
			return false;
	}
	
	private static boolean checkOutOfRoom() {
		Scanner in = new Scanner(System.in);
		String hId, rrId = hId = "";
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		System.out.println("Enter corresponding room reservation id");
		if(in.hasNextLine())
			rrId = in.nextLine().trim();
		
		return new HotelController().checkOutOfRoom(hId, rrId);
	}
	
	private static boolean checkIntoRoom() {
		Scanner in = new Scanner(System.in);
		String hId, rrId = hId = "";
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		System.out.println("Enter corresponding room reservation id");
		if(in.hasNextLine())
			rrId = in.nextLine().trim();
		
		return new HotelController().checkIntoRoom(hId, rrId);
	}
	
	private static boolean updateRoomInvoice() {
		Scanner in = new Scanner(System.in);
		String hId, riId = hId = "";
		int flag = -1;
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		System.out.println("Enter room invoice id you wish to update");
		if(in.hasNextLine())
			riId = in.nextLine().trim();
		System.out.println("What would you like to update?\n" +
				"0. Notes\n" +
				"1. Room id\n");
		
		if(in.hasNextLine())
			flag = Integer.parseInt(in.nextLine().trim());

		if(flag == 0) {
			System.out.println("Enter the new notes");
			String notes = "";
			if(in.hasNextLine())
				notes = in.nextLine().trim();
			return new HotelController().updateRoomInvoice(hId, riId, notes, RoomInvoice.UPDATE_NOTES);	
		}
		else if(flag == 1) {
			System.out.println("Enter in the new room id.");
			int rId = -1;
			if(in.hasNextLine())
				rId = Integer.parseInt(in.nextLine().trim());
			return new HotelController().updateRoomInvoice(hId, riId, rId, RoomInvoice.UPDATE_ROOM_ID);
		}
		else
			return false;
	}
	
	private static boolean updateRoomReservation() {
		Scanner in = new Scanner(System.in);
		String hId, rrId = hId = "";
		int choice = -1;
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		System.out.println("Enter room reservation id you wish to update");
		if(in.hasNextLine())
			rrId = in.nextLine().trim();
		System.out.println("What would you like to update?\n" +
				"0. Hotel id\n" +
				"1. Customer\n" +
				"2. Start date\n" +
				"3. End date\n" +
				"4. Room id");
		if(in.hasNextLine())
			choice = Integer.parseInt(in.nextLine().trim());
		
		if(choice == 0) {
			String newId = "";
			System.out.println("Enter the new hotel id");
			if(in.hasNextLine())
				newId = (in.nextLine().trim());
			return new HotelController().updateRoomReservation(hId, rrId, RoomReservation.UPDATE_HOTEL_ID, newId);	
		}
		else if(choice == 1) {
			String fname, lname = fname = "";
			int cid = -1;
			System.out.println("Enter the new customer id");
			if(in.hasNextLine())
				cid = Integer.parseInt(in.nextLine().trim());
			System.out.println("Enter new first name");
			if(in.hasNextLine())
				fname = in.nextLine().trim();
			System.out.println("Enter new last name");
			if(in.hasNextLine())
				lname = in.nextLine().trim();
			Customer c = new Customer(cid, fname, lname);
			return new HotelController().updateRoomReservation(hId, rrId, RoomReservation.UPDATE_CUSTOMER, c);
		}
		else if(choice == 2) {
			System.out.println("Enter new start date (MM/dd/yyyy)");
			String start = "";
			if(in.hasNextLine())
				start = in.nextLine().trim();
			return new HotelController().updateRoomReservation(hId, rrId, RoomReservation.UPDATE_START_DATE, start);
		}
		else if(choice == 3) {
			System.out.println("Enter new end date (MM/dd/yyyy)");
			String end = "";
			if(in.hasNextLine())
				end = in.nextLine().trim();
			return new HotelController().updateRoomReservation(hId, rrId, RoomReservation.UPDATE_END_DATE, end);
		}
		else if(choice == 4) {
			int rId = -1;
			System.out.println("Enter new room id");
			if(in.hasNextLine())
				rId = Integer.parseInt(in.nextLine().trim());
			return new HotelController().updateRoomReservation(hId, rrId, RoomReservation.UPDATE_ROOM_ID, rId);
		}
		else
			return false;
	}
	
	private static boolean searchRooms() {
		Scanner in = new Scanner(System.in);
		String hId = "";
		int flag = -1;
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		System.out.println("What would you like to search by?\n" +
				"1. Room id\n" +
				"2. Room Occupancy\n" +
				"3. Number of beds\n" +
				"4. Status (Checked in or out)");
		if(in.hasNextLine())
			flag = Integer.parseInt(in.nextLine().trim());
		List<Room> results = null;
		if(flag == 1) {
			System.out.println("What id do you want to search by?");
			int id = -1;
			if(in.hasNextLine())
				id = Integer.parseInt(in.nextLine().trim());
			results = new HotelController().searchRooms(hId, id, HotelInterface.SEARCH_BY_ID);
		}
		else if(flag == 2) {
			System.out.println("What room occupancy would you like to search for?");
			int occup = -1;
			if(in.hasNextLine())
				occup = Integer.parseInt(in.nextLine().trim());
			results = new HotelController().searchRooms(hId, new Integer(occup), HotelInterface.SEARCH_BY_OCCUPANCY);
		}
		else if(flag == 3) {
			System.out.println("What number of beds would you like to search for?");
			int numBeds = -1;
			if(in.hasNextLine())
				numBeds = Integer.parseInt(in.nextLine().trim());
			results = new HotelController().searchRooms(hId, new Integer(numBeds), HotelInterface.SEARCH_BY_NUM_BEDS);
		}
		else if(flag == 4) {
			System.out.println("What status do you want to search by (1 for occupied, 0 for empty)?");
			int incoming = -1;
			boolean stat = false;
			if(in.hasNextLine()) {
				incoming = Integer.parseInt(in.nextLine().trim());
				if(incoming == 0)
					stat = false;
				else if(incoming == 1)
					stat = true;
				else return false;
			}
			results = new HotelController().searchRooms(hId, stat, HotelInterface.SEARCH_BY_STATUS);
		}
		else 
			return false;
		
		if(results == null) {
			System.out.println("There are no rooms that meet that criteria.");
			return true;
		}
		
		System.out.println("ID \t OCCUPANCY \t CHECKEDIN" + (flag == 3 ? "\tBEDS" : ""));
		for(Room r: results) {
			System.out.println(r.getRoomID() + "\t " + r.getOccupancy() + "\t\t" + r.getStatus() + (flag == 3 ? "\t\t" + r.getBeds().toString() : ""));
		}
		
		return true;
	}
	
	private static boolean checkRoomAvailability() {
		
		Scanner in = new Scanner(System.in);
		String hId, start, end = start = hId = "";
		
		System.out.println("Enter hotel id");
		if(in.hasNextLine())
			hId = in.nextLine().trim();
		System.out.println("Enter start date (MM/dd/yyyy)");
		if(in.hasNextLine())
			start = in.nextLine().trim();
		System.out.println("Enter end date (MM/dd/yyyy)");
		if(in.hasNextLine())
			end = in.nextLine().trim();
		
		List<Room> results = null;
		results = new HotelController().checkRoomAvailability(hId, start, end);
		if(results == null) {
			System.out.println("There are no available rooms.");
			return true;
		}
		System.out.println("Available Rooms between " + start + " and " + end);
		System.out.println("ID \t OCCUPANCY \t CHECKEDIN \t BEDS");
		for(Room r: results) {
			System.out.println(r.getRoomID() + "\t " + r.getOccupancy() + "\t\t" + r.getStatus() + "\t\t" + r.getBeds().toString());
		}
		
		return true;
	}

}

