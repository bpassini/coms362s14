package edu.iastate.cs362.RentalCenter;

import javax.swing.JOptionPane;

import edu.iastate.cs362.Hotel.Customer;

public class RentalCenterUI {
	public static void main(String[] args) {
		String operationNumber=JOptionPane.showInputDialog(
			    "Enter operation number \n"+
			    " 1. Create a Rental Center\n"+
			    " 2. Create a piece of Equipment to a specific RentalCenter\n"+
			    " 3. Create an Equipment Invoice to a specific RentalCenter\n " +
			    " 4. Create a Rental Reservation to a specific RentalCenter\n" +
			    " 5. Update a piece of Equipment.\n" +
			    " 6. Update a Rental Center.\n" +
			    " 7. Checkout a piece of Equipment.\n" +
			    " 8. Check in a piece of Equipment.\n" +
			    " 9. Update Equipment Invoice.\n" +
			    "10. Update Rental Reservation.\n");
		int code = Integer.parseInt(operationNumber);
			
		if(code==1){
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				String name=JOptionPane.showInputDialog("Enter rental center name");
				boolean b=new RentalCenterController().createRentalCenter(rId, name);
				System.out.println("Operation success boolean is "+b);
			}
			if(code==2){
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				String eId=JOptionPane.showInputDialog("Enter new equipment id");
				String type = JOptionPane.showInputDialog("Enter equipment type");
				double cost = Double.parseDouble(JOptionPane.showInputDialog("Enter cost to rent this equipment"));
				String descr = JOptionPane.showInputDialog("Enter equipment description");
				boolean b=new RentalCenterController().addEquipment(rId, eId, type, cost, descr, false);
				System.out.println("Operation success boolean is "+b);
			}
			if(code==3){
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				String iId=JOptionPane.showInputDialog("Enter new equipment invoice id");
				String eId=JOptionPane.showInputDialog("Enter id for corresponding piece of equipment");
				String descr = JOptionPane.showInputDialog("Enter invoice message");
				boolean b=new RentalCenterController().createEquipInvoice(rId, iId, eId, descr);
				System.out.println("Operation success boolean is "+b);
			}	
			if(code == 4) {
				String rcId=JOptionPane.showInputDialog("Enter rental center id");
				String rId=JOptionPane.showInputDialog("Enter rental reservation id");
				String eId=JOptionPane.showInputDialog("Enter id for corresponding piece of equipment");
				int cid = Integer.parseInt(JOptionPane.showInputDialog("Enter a new customer id (integer)"));
				String fname = JOptionPane.showInputDialog("Enter customer's first name");
				String lname = JOptionPane.showInputDialog("Enter customer's last name");
				String start = JOptionPane.showInputDialog("Enter start date and time (MM/dd/yyyy hh::mm)");
				String end = JOptionPane.showInputDialog("Enter end date and time (MM/dd/yyyy hh::mm)");
				boolean b=new RentalCenterController().createRentalReservation(rcId, rId, eId, new Customer(cid, fname, lname), start, end);
				System.out.println("Operation success boolean is "+b);
				
				
			}
			
			if(code == 5) {
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				String eId=JOptionPane.showInputDialog("Enter equipment id you wish to update");
				int flag = Integer.parseInt(JOptionPane.showInputDialog("What would you like to update?\n" +
						"0. Equipment Type\n" +
						"1. Cost\n" +
						"2. Description\n"));
				boolean b = false;
				if(flag == 0) {
					String type = JOptionPane.showInputDialog("Enter the equipment type.");
					b=new RentalCenterController().updateEquipment(rId, eId, flag, type);	
				}
				else if(flag == 1) {
					double cost = Double.parseDouble(JOptionPane.showInputDialog("Enter in the new cost."));
					b = new RentalCenterController().updateEquipment(rId, eId, flag, cost);
				}
				else if(flag == 2) {
					String desc = JOptionPane.showInputDialog("Enter the new description.");
					b=new RentalCenterController().updateEquipment(rId, eId, flag, desc);	
				}
				System.out.println("Operation success boolean is "+b);
			}
			if(code == 6) {
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				int flag = Integer.parseInt(JOptionPane.showInputDialog("What would you like to update?" +
						"0. Name"));
				boolean b = false;
				if(flag == 0) {
					String name = JOptionPane.showInputDialog("Enter the new name.");
					b=new RentalCenterController().updateRentalCenter(rId, flag, name);
				}
				
				System.out.println("Operation success boolean is "+b);
			}
			if(code == 7) {
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				String eId=JOptionPane.showInputDialog("Enter equipment id you wish to update");
				String rentalId = JOptionPane.showInputDialog("Enter corresponding rental reservation id");
				boolean b = new RentalCenterController().checkOutEquipment(rId, eId, rentalId);
				System.out.println("Operation success boolean is "+b);
			}
			if(code == 8) {
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				String eId=JOptionPane.showInputDialog("Enter equipment id you wish to update");
				String rentalId = JOptionPane.showInputDialog("Enter corresponding rental reservation id");
				boolean b = new RentalCenterController().checkInEquipment(rId, eId, rentalId);
				System.out.println("Operation success boolean is "+b);
			}
			if(code == 9) {
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				String eId=JOptionPane.showInputDialog("Enter equipment invoice id you wish to update");
				int flag = Integer.parseInt(JOptionPane.showInputDialog("What would you like to update?" +
						"0. Message\n" +
						"1. Equipment id\n"));
				boolean b = false;
				if(flag == 0) {
					String msg = JOptionPane.showInputDialog("Enter the new message.");
					b=new RentalCenterController().updateEquipmentInvoice(rId, eId, flag, msg);	
				}
				else if(flag == 1) {
					String eqId = JOptionPane.showInputDialog("Enter in the new equipment id.");
					b = new RentalCenterController().updateEquipmentInvoice(rId, eId, flag, eqId);
				}
				System.out.println("Operation success boolean is "+b);
			}
			if(code == 10) {
				String rId=JOptionPane.showInputDialog("Enter rental center id");
				String resId=JOptionPane.showInputDialog("Enter rental reservation id you wish to update");
				int flag = Integer.parseInt(JOptionPane.showInputDialog("What would you like to update?" +
						"0. Equipment id\n" +
						"1. Customer\n" +
						"2. Start date\n" +
						"3. End date"));
				boolean b = false;
				if(flag == 0) {
					String id = JOptionPane.showInputDialog("Enter the new equipment id.");
					b=new RentalCenterController().updateRentalReservation(rId, resId, flag, id);	
				}
				else if(flag == 1) {
					int cId = Integer.parseInt(JOptionPane.showInputDialog("Enter in the new customer id."));
					String first = JOptionPane.showInputDialog("Enter new first name.");
					String last = JOptionPane.showInputDialog("Enter new last name.");
					Customer c = new Customer(cId, first, last);
					b = new RentalCenterController().updateRentalReservation(rId, resId, flag, c);
				}
				else if(flag == 2) {
					String start = JOptionPane.showInputDialog("Enter new start date.(MM/dd/yyyy hh::mm)");
					b = new RentalCenterController().updateRentalReservation(rId, resId, flag, start);
				}
				else if(flag == 3) {
					String end = JOptionPane.showInputDialog("Enter new end date.(MM/dd/yyyy hh::mm)");
					b = new RentalCenterController().updateRentalReservation(rId, resId, flag, end);
				}
				System.out.println("Operation success boolean is "+b);
			}
	}

}
