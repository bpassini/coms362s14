package edu.iastate.cs362.Resort;

import edu.iastate.cs362.Hotel.Attribute;
import edu.iastate.cs362.Hotel.Customer;

public interface ResortInterface {
	boolean createRentalCenter(String rid, String name);
	boolean createHotel(String hid, String name);
	boolean addEquipment(String rid, String eid, String equipType, double cost, String description);
	boolean createEquipInvoice(String rid, String eid, String msg);
	boolean createRentalReservation(String rid, String eid, String cname, Date start, Date end);
	boolean addRoom(int beds, int occup, String desc, int rmid);
	boolean createRoomInvoice(int rmid, String notes);
	boolean createRoomReservation(String hotel, Date start, Date end, Customer cust, Attribute attr);
}
