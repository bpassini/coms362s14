package edu.iastate.cs362.Resort;

import org.joda.time.*;

import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;
import org.joda.time.*;

public interface ResortInterface {
	/**
	 * Creates a new RentalCenter
	 * @param rid - the RentalCenter id
	 * @param name - the name of the RentalCenter
	 * @return true if RentalCenter was created successfully, false otherwise 
	 */
	boolean createRentalCenter(String rid, String name);
	boolean createHotel(String hid, String name);
	/**
	 * Create and add a piece of Equipment to a specific RentalCenter.
	 * @param rid - the RentalCenter id
	 * @param eid - the Equipment id
	 * @param equipType - the type of equipment
	 * @param cost - the rental cost of the equipment
	 * @param description - a description of the equipment
	 * @return true if the Equipment was added successfully, false otherwise
	 */
	boolean addEquipment(String rid, String eid, String equipType, double cost, String description);
	boolean addRoom(String hid, int beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String notes);
	boolean createRoomReservation(String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
	/**
	 * Creates an EquipmentInvoice for a piece of Equipment in a RentalCenter
	 * @param rid - the RentalCenter id
	 * @param invoiceId - the EquipmentInvoice id
	 * @param eid - the Equipment id
	 * @param msg - a description of the invoice and what is wrong with the Equipment
	 * @return true if the EquipmentInvoice is created successfully, false otherwise
	 */
	boolean createEquipInvoice(String rid, String invoiceId,  String eid, String msg);
	/**
	 * Creates a RentalReservation for a piece of equipment in a specific RentalCenter.
	 * @param rid - the RentalCenter id
	 * @param rentalId - the RentalReservation id
	 * @param eid - the corresponding Equipment id
	 * @param cname - the customer name 
	 * @param start - the start time of the reservation
	 * @param end - the end time of the reservation
	 * @return true if RentalReservation was created successfully, false otherwise
	 */
	boolean createRentalReservation(String rid, String rentalId, String eid, String cname, DateTime start, DateTime end);
}
