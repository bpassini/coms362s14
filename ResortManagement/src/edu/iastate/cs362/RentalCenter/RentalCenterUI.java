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
			    " 4. Create a Rental Reservation to a specific RentalCenter\n");
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
				boolean b=new RentalCenterController().addEquipment(rId, eId, type, cost, descr);
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
				String start = JOptionPane.showInputDialog("Enter start date and time (dd/MM/yyyy hh::mm)");
				String end = JOptionPane.showInputDialog("Enter end date and time (dd/MM/yyyy hh::mm)");
				boolean b=new RentalCenterController().createRentalReservation(rcId, rId, eId, new Customer(cid, fname, lname), start, end);
				System.out.println("Operation success boolean is "+b);
				
				
			}
	}

}
