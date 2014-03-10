package edu.iastate.cs362.Resort;

import org.joda.time.*;

import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;
import org.joda.time.*;

public interface ResortInterface {
	boolean createRentalCenter(String rid, String name);
	boolean createHotel(String hid, String name);
	boolean addEquipment(String rid, String eid, String equipType, double cost, String description);
	boolean addRoom(String hid, int beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String notes);
	boolean createRoomReservation(String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
	boolean createEquipInvoice(String rid, String invoiceId,  String eid, String msg);
	boolean createRentalReservation(String rid, String rentalId, String eid, String cname, DateTime start, DateTime end);
}
