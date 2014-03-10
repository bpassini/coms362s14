package edu.iastate.cs362.Resort;

import org.joda.time.*;

import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;

public interface ResortInterface {
	boolean createRentalCenter(String rid, String name);
	boolean createHotel(String hid, String name);
	boolean addEquipment(String rid, String eid, String equipType, double cost, String description);
	boolean createEquipInvoice(String rid, String eid, String msg);
	boolean createRentalReservation(String rid, String eid, String cname, DateTime start, DateTime end);
	boolean addRoom(String hid, int beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(String hid, int rmid, String notes);
	boolean createRoomReservation(String hid, DateTime start, DateTime end, Customer cust, Attribute attr);
}
