package edu.iastate.cs362.Resort;

import java.util.ArrayList;

import org.joda.time.*;

import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;

/**
 * Interface for Resort.
 * 
 * @author Cameron Johnston
 *
 */
public interface ResortInterface {
	/**
	 * Creates a new RentalCenter
	 * @param rId - the RentalCenter id
	 * @param name - the name of the RentalCenter
	 * @return true if RentalCenter was created successfully, false otherwise 
	 */
	boolean createRentalCenter(String rId, String name);
	
	
	boolean createHotel(String hid, String name);

	boolean addRoom(String hid, ArrayList<String> beds, int occup, String desc, int rmid);

	/**
	 * Create and add a piece of Equipment to a specific RentalCenter.
	 * @param rId - the RentalCenter id
	 * @param equipId - the Equipment id
	 * @param equipType - the type of equipment
	 * @param cost - the rental cost of the equipment
	 * @param description - a description of the equipment
	 * @return true if the Equipment was added successfully, false otherwise
	 */
	boolean addEquipment(String rId, String equipId, String equipType, double cost, String description);
	boolean createRoomInvoice(String hid, int rmid, String notes);
	boolean createRoomReservation(String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
	/**
	 * Creates an EquipmentInvoice for a piece of Equipment in a RentalCenter
	 * @param rId - the RentalCenter id
	 * @param invoiceId - the EquipmentInvoice id
	 * @param equipId - the Equipment id
	 * @param msg - a description of the invoice and what is wrong with the Equipment
	 * @return true if the EquipmentInvoice is created successfully, false otherwise
	 */
	boolean createEquipInvoice(String rId, String invoiceId,  String equipId, String msg);
	/**
	 * Creates a RentalReservation for a piece of equipment in a specific RentalCenter.
	 * @param rId - the RentalCenter id
	 * @param rentalId - the RentalReservation id
	 * @param equipId - the corresponding Equipment id
	 * @param customer - the customer
	 * @param start - the start time of the reservation
	 * @param end - the end time of the reservation
	 * @return true if RentalReservation was created successfully, false otherwise
	 */
	boolean createRentalReservation(String rId, String rentalId, String equipId, Customer customer, DateTime start, DateTime end);
}
