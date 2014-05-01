package edu.iastate.cs362.RentalCenter;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.ManagementSystem.ManagementSystemController;
import edu.iastate.cs362.Resort.Resort;

public class RentalCenterUI {
	public static void main(String[] args) {
		
		System.out.println("\t\t Rental Center\n");
		System.out.println("What would you like to do? \n"+
			    " 1. Create a Rental Center\n"+
			    " 2. Create a piece of Equipment to a specific RentalCenter\n"+
			    " 3. Create an Equipment Invoice to a specific RentalCenter\n" +
			    " 4. Create a Rental Reservation to a specific RentalCenter\n" +
			    " 5. Update a piece of Equipment.\n" +
			    " 6. Update a Rental Center.\n" +
			    " 7. Checkout a piece of Equipment.\n" +
			    " 8. Check in a piece of Equipment.\n" +
			    " 9. Update Equipment Invoice.\n" +
			    "10. Update Rental Reservation.\n" + 
			    "11. Search for Equipment.\n" +
			    "12. Check Equipment Availability.");
		
		Scanner in = new Scanner(System.in);
		boolean returnCode = false;
		while(true) {
			
			System.out.println("What would you like to do? \n"+
				    " 1. Create a Rental Center\n"+
				    " 2. Create a piece of Equipment to a specific RentalCenter\n"+
				    " 3. Create an Equipment Invoice to a specific RentalCenter\n" +
				    " 4. Create a Rental Reservation to a specific RentalCenter\n" +
				    " 5. Update a piece of Equipment.\n" +
				    " 6. Update a Rental Center.\n" +
				    " 7. Checkout a piece of Equipment.\n" +
				    " 8. Check in a piece of Equipment.\n" +
				    " 9. Update Equipment Invoice.\n" +
				    "10. Update Rental Reservation.\n" + 
				    "11. Search for Equipment.\n" +
				    "12. Check Equipment Availability.");
			
			int inputNum = 0;
			if(in.hasNextLine()) {
				inputNum = Integer.parseInt(in.nextLine().trim());
			}
			if(inputNum == 1)
				returnCode = createRC();
			else if(inputNum == 2)
				returnCode = createEquipment();
			else if(inputNum == 3)
				returnCode = createEquipInvoice();
			else if(inputNum == 4)
				returnCode = createRentalReservation();
			else if(inputNum == 5)
				returnCode = updateEquipment();
			else if(inputNum == 6)
				returnCode = updateRC();
			else if(inputNum == 7)
				returnCode = checkoutEquip();
			else if(inputNum == 8)
				returnCode = checkinEquip();
			else if(inputNum == 9)
				returnCode = updateEquipInvoice();
			else if(inputNum == 10)
				returnCode = updateRentalReservation();
			else if(inputNum == 11)
				returnCode = searchEquipment();
			else if(inputNum == 12)
				returnCode = checkAvailability();
			else
				break;
			
			if(!returnCode) {
				System.out.println("Operation failed, please try again.");
			}
			else {
				System.out.println("Operation succeeded!");
			}
		}
		in.close();
	}

	private static boolean createRC() {
		Scanner in = new Scanner(System.in);
		String id, name = id = "";
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			id = in.nextLine().trim();
		System.out.println("Enter rental center name");
		if(in.hasNextLine())
			name = in.nextLine().trim();
		
		return new RentalCenterController().createRentalCenter(id, name);
	}
	
	private static boolean createEquipment() {
		
		Scanner in = new Scanner(System.in);
		String rid, eid, type, descr = eid = type = rid = "";
		double cost = 0.0;
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
				rid = in.nextLine().trim();
		System.out.println("Enter new equipment id");
		if(in.hasNextLine())
			eid = in.nextLine().trim();
		System.out.println("Enter equipment type");
		if(in.hasNextLine())
			type = in.nextLine().trim();
		System.out.println("Enter cost to rent this equipment");
		if(in.hasNextLine())
			cost = Double.parseDouble(in.nextLine().trim());
		System.out.println("Enter equipment description");
		if(in.hasNextLine())
			descr = in.nextLine().trim();
		return new RentalCenterController().addEquipment(rid, eid, type, cost, descr, true);
	}
	
	private static boolean createEquipInvoice() {
		Scanner in = new Scanner(System.in);
		String rId, iId, eId, descr = eId = iId = rId = "";
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("Enter new equipment invoice id");
		if(in.hasNextLine())
			iId = in.nextLine().trim();
		System.out.println("Enter id for corresponding piece of equipment");
		if(in.hasNextLine())
			eId = in.nextLine().trim();
		System.out.println("Enter invoice message");
		if(in.hasNextLine())
			descr = in.nextLine().trim();
		return new RentalCenterController().createEquipInvoice(rId, iId, eId, descr);
	}
	
	private static boolean createRentalReservation() {
		Scanner in = new Scanner(System.in);
		String rcId, rId, eId, fname, lname, start, end = start = lname = fname = eId = rId = rcId = "";
		int cid = -1;
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rcId = in.nextLine().trim();
		System.out.println("Enter rental reservation id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("Enter id for corresponding piece of equipment");
		if(in.hasNextLine())
			eId = in.nextLine().trim();
		System.out.println("Enter a new customer id (integer)");
		if(in.hasNextLine())
			cid = Integer.parseInt(in.nextLine().trim());
		System.out.println("Enter customer's first name");
		if(in.hasNextLine())
			fname = in.nextLine().trim();
		System.out.println("Enter customer's last name");
		if(in.hasNextLine())
			lname = in.nextLine().trim();
		System.out.println("Enter start date and time (MM/dd/yyyy hh::mm)");
		if(in.hasNextLine())
			start = in.nextLine().trim();
		System.out.println("Enter end date and time (MM/dd/yyyy hh::mm)");
		if(in.hasNextLine())
			end = in.nextLine().trim();
		return new RentalCenterController().createRentalReservation(rcId, rId, eId, new Customer(cid, fname, lname), start, end);
	}
	
	private static boolean updateEquipment() {
		Scanner in = new Scanner(System.in);
		String rId, eId, type, desc = type = eId = rId = "";
		int flag = -1;
		double cost = 0.0;
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("Enter equipment id you wish to update");
		if(in.hasNextLine())
			eId = in.nextLine().trim();
		System.out.println("What would you like to update?\n" +
				"0. Equipment Type\n" +
				"1. Cost\n" +
				"2. Description\n");
		
		if(in.hasNextLine())
			flag = Integer.parseInt(in.nextLine().trim());
		
		if(flag == 0) {
			System.out.println("Enter the equipment type.");
			if(in.hasNextLine())
				type = in.nextLine().trim();
			return new RentalCenterController().updateEquipment(rId, eId, flag, type);	
		}
		else if(flag == 1) {
			System.out.println("Enter in the new cost.");
			if(in.hasNextLine())
				cost = Double.parseDouble(in.nextLine().trim());
			return new RentalCenterController().updateEquipment(rId, eId, flag, cost);
		}
		else if(flag == 2) {
			System.out.println("Enter the new description.");
			if(in.hasNextLine())
				desc = in.nextLine().trim();
			return new RentalCenterController().updateEquipment(rId, eId, flag, desc);	
		}
		else
			return false;
	}
	
	private static boolean updateRC() {
		Scanner in = new Scanner(System.in);
		String rId, name = rId = "";
		int flag = -1;
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		
		System.out.println("What would you like to update?\n" +
				"0. Name");		
		if(in.hasNextLine())
			flag = Integer.parseInt(in.nextLine().trim());
		
		if(flag == 0) {
			System.out.println("Enter the new name.");
			if(in.hasNextLine())
				name = in.nextLine().trim();
			return new RentalCenterController().updateRentalCenter(rId, flag, name);
		}
		else
			return false;
	}
	
	private static boolean checkoutEquip() {
		Scanner in = new Scanner(System.in);
		String rId, eId, rentalId = rId = eId = "";
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("Enter corresponding rental reservation id");
		if(in.hasNextLine())
			rentalId = in.nextLine().trim();
		
		return new RentalCenterController().checkOutEquipment(rId,rentalId);
	}
	
	private static boolean checkinEquip() {
		Scanner in = new Scanner(System.in);
		String rId, eId, rentalId = eId = rId = "";
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("Enter corresponding rental reservation id");
		if(in.hasNextLine())
			rentalId = in.nextLine().trim();
		
		return new RentalCenterController().checkInEquipment(rId, rentalId);
	}
	
	private static boolean updateEquipInvoice() {
		
		Scanner in = new Scanner(System.in);
		String rId, eId, msg, eqId = msg = eId = rId = "";
		int flag = -1;
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("Enter equipment invoice id you wish to update");
		if(in.hasNextLine())
			eId = in.nextLine().trim();
		System.out.println("What would you like to update?\n" +
				"0. Message\n" +
				"1. Equipment id\n");
		
		if(in.hasNextLine())
			flag = Integer.parseInt(in.nextLine().trim());

		if(flag == 0) {
			System.out.println("Enter the new message.");
			if(in.hasNextLine())
				msg = in.nextLine().trim();
			return new RentalCenterController().updateEquipmentInvoice(rId, eId, flag, msg);	
		}
		else if(flag == 1) {
			System.out.println("Enter in the new equipment id.");
			if(in.hasNextLine())
				eqId = in.nextLine().trim();
			return new RentalCenterController().updateEquipmentInvoice(rId, eId, flag, eqId);
		}
		else
			return false;
	}
	
	private static boolean updateRentalReservation() {
		
		Scanner in = new Scanner(System.in);
		String rId, resId, eId, start, end = rId = resId = eId = start = "";
		int flag = -1, cid = -1;
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("Enter rental reservation id you wish to update");
		if(in.hasNextLine())
			resId = in.nextLine().trim();
		System.out.println("What would you like to update?\n" +
				"0. Equipment id\n" +
				"1. Customer\n" +
				"2. Start date\n" +
				"3. End date");
		if(in.hasNextLine())
			flag = Integer.parseInt(in.nextLine().trim());
		
		if(flag == 0) {
			System.out.println("Enter the new equipment id.");
			if(in.hasNextLine())
				eId = in.nextLine().trim();
			return new RentalCenterController().updateRentalReservation(rId, resId, flag, eId);	
		}
		else if(flag == 1) {
			System.out.println("Enter in the new customer id.");
			if(in.hasNextLine())
				cid = Integer.parseInt(in.nextLine().trim());
			System.out.println("Enter new first name.");
			String first, last = first = "";
			if(in.hasNextLine())
				first = in.nextLine().trim();
			System.out.println("Enter new last name.");
			if(in.hasNextLine())
				last = in.nextLine().trim();
			Customer c = new Customer(cid, first, last);
			return new RentalCenterController().updateRentalReservation(rId, resId, flag, c);
		}
		else if(flag == 2) {
			System.out.println("Enter new start date.(MM/dd/yyyy hh::mm)");
			if(in.hasNextLine())
				start = in.nextLine().trim();
			return new RentalCenterController().updateRentalReservation(rId, resId, flag, start);
		}
		else if(flag == 3) {
			System.out.println("Enter new end date.(MM/dd/yyyy hh::mm)");
			if(in.hasNextLine())
				end = in.nextLine().trim();
			return new RentalCenterController().updateRentalReservation(rId, resId, flag, end);
		}
		else
			return false;
	}
	
	private static boolean searchEquipment() {
		Scanner in = new Scanner(System.in);
		String rId = "";
		int flag = -1, cid = -1;
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("What would you like to search by?\n" +
				"1. Equipment id\n" +
				"2. Type\n" +
				"3. Cost\n" +
				"4. Status (Checked in or out)");
		if(in.hasNextLine())
			flag = Integer.parseInt(in.nextLine().trim());
		List<Equipment> results = null;
		if(flag == 1) {
			System.out.println("What id do you want to search by?");
			String id = "";
			if(in.hasNextLine())
				id = in.nextLine().trim();
			results = new RentalCenterController().searchEquipment(rId, id, flag);
		}
		else if(flag == 2) {
			System.out.println("What type do you want to search by?");
			String type = "";
			if(in.hasNextLine())
				type = in.nextLine().trim();
			results = new RentalCenterController().searchEquipment(rId, type, flag);
		}
		else if(flag == 3) {
			System.out.println("What cost do you want to search by?");
			double cost = 0.0;
			if(in.hasNextLine())
				cost = Double.parseDouble(in.nextLine().trim());
			results = new RentalCenterController().searchEquipment(rId, cost, flag);
		}
		else if(flag == 4) {
			System.out.println("What status do you want to search by (1 for checkedIn, 0 for checkedOut)?");
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
			results = new RentalCenterController().searchEquipment(rId, stat, flag);
		}
		else 
			return false;
		
		System.out.println("ID \t TYPE \t COST \t CHECKEDIN");
		for(Equipment e: results) {
			System.out.println(e.getEquipId() + "\t " + e.getEquipType() + "\t" + e.getCost() + "\t" + e.getStatus());
		}
		
		return true;
	}
	
	private static boolean checkAvailability() {
		Scanner in = new Scanner(System.in);
		String rId, start, end = start = rId = "";
		
		System.out.println("Enter rental center id");
		if(in.hasNextLine())
			rId = in.nextLine().trim();
		System.out.println("Enter start date and time (MM/dd/yyyy)");
		if(in.hasNextLine())
			start = in.nextLine().trim();
		System.out.println("Enter end date and time (MM/dd/yyyy)");
		if(in.hasNextLine())
			end = in.nextLine().trim();
		List<Equipment> results = null;
		results = new RentalCenterController().checkEquipmentAvailability(rId, start, end);
		if(results == null) {
			System.out.println("There was no available equipment.");
			return false;
		}
		System.out.println("Available Equipment between " + start + " and " + end);
		System.out.println("ID \t TYPE \t COST \t CHECKEDIN");
		for(Equipment e: results) {
			System.out.println(e.getEquipId() + "\t " + e.getEquipType() + "\t" + e.getCost() + "\t" + e.getStatus());
		}
		
		return true;
	}

}
