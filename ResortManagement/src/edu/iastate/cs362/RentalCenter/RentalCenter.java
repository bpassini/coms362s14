package edu.iastate.cs362.RentalCenter;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import edu.iastate.cs362.Hotel.Customer;
/**
 * Class representing a RentalCenter.  Our resort can own many different RentalCenters.
 * @author Cameron Johnston
 * @author Bryan Passini
 *
 */
public class RentalCenter implements RentalCenterInterface {
	
	/**
	 * The id for this Rental Center.
	 */
	private String rId;
	
	/**
	 *  The name of this Rental Center.
	 */
	private String name;
	
	
	/**
	 * The equipment this RentalCenter holds.
	 */
	private List<Equipment> equipment;
	/**
	 * The invoices this RentalCenter has for its equipment.
	 */
	private List<EquipmentInvoice> invoices;
	/**
	 * The reservations this RentalCenter has for its equipment.
	 */
	private List<RentalReservation> reservations;
	
	/**
	 * Creates a new RentalCenter object.
	 * @param rId - The id for this Rental Center.
	 * @param name - The name of this Rental Center.
	 */
	public RentalCenter(String rId, String name) {
		this.rId = rId;
		this.name = name;
		equipment = new ArrayList<Equipment>();
		invoices = new ArrayList<EquipmentInvoice>();
		reservations = new ArrayList<RentalReservation>();
	}

	@Override
	public boolean addEquipment(String eid, String equipType, double cost,
			String description, boolean checkedIn) {
		
		Equipment e = new Equipment(eid, equipType, cost, description, checkedIn);
		return equipment.add(e);
	}

	@Override
	public boolean createEquipInvoice(String invoiceId, String eid, String msg) {
		
		EquipmentInvoice i = new EquipmentInvoice(invoiceId, eid, msg);
		return invoices.add(i);
	}

	@Override
	public boolean createRentalReservation(String rentalId, String eid, Customer cust,
			DateTime start, DateTime end) {
		
		RentalReservation r = new RentalReservation(rentalId, eid, cust, start, end);
		return reservations.add(r);
	}
	
	@Override
	public boolean updateEquipmentInvoice(String invoiceId, int flag, Object newInfo) {
		EquipmentInvoice temp = null;
		for(EquipmentInvoice ei : invoices) {
			if(ei.getInvoiceId().equals(invoiceId)) {
				temp = ei;
				break;
			}
		}
		//An equipment invoice with the given invoiceId was not found.
		if(temp == null)
			return false;
		if(temp.updateEquipmentInvoice(flag, newInfo)) {
			//Place the updated equipment invoice at the end of the list and then return if the add was successful or not.
			return invoices.remove(temp) && invoices.add(temp);
		}
		return false;
	}
	
	@Override
	public boolean updateRentalReservation(String reservationId, int flag, Object newInfo) {
		RentalReservation temp = null;
		for(RentalReservation rr : reservations) {
			if(rr.getRentalId().equals(reservationId)) {
				temp = rr;
				break;
			}
		}
		//A rental reservation with the given id was not found.
		if(temp == null)
			return false;
		if(temp.updateRentalReservaion(flag, newInfo)) {
			//Place updated rental reservation at the end of the list and then return if the add was successful or not.
			return reservations.remove(temp) && reservations.add(temp);
		}
		return false;
	}
	
	@Override
	public boolean updateRentalCenter(int flag, Object u) {
		
		if(u instanceof String) {
			if(flag == UPDATE_NAME) 
				name = (String) u;	
		}
		else 
			return false;
	
		return true;
	}

	@Override
	public boolean checkOutEquipment(String eid, String rentalId) {
		
		
		Equipment tmp = null;
		for(Equipment e : equipment) {
			if(e.getEquipId().equals(eid)) {
				tmp = e;
				break;
			}
		}
		RentalReservation tmpr = null;
		for(RentalReservation r: reservations) {
			if(r.getRentalId().equals(rentalId)) {
				tmpr = r;
				break;
			}
		}
		
		if(tmp == null || tmpr == null) {
			return false;
		}
		else if(tmp.checkOutEquipment()) {
			tmpr.setEquipId(eid);
			boolean e = equipment.remove(tmp) && equipment.add(tmp);
			boolean r = reservations.remove(tmpr) && reservations.add(tmpr);
			return e && r;
		}
		else
			return false;
		
	}

	@Override
	public boolean checkInEquipment(String eid, String rentalId) {
		
		Equipment tmp = null;
		for(Equipment e : equipment) {
			if(e.getEquipId().equals(eid)) {
				tmp = e;
				break;
			}
		}
		RentalReservation tmpr = null;
		for(RentalReservation r: reservations) {
			if(r.getRentalId().equals(rentalId)) {
				tmpr = r;
				break;
			}
		}
		
		if(tmp == null || tmpr == null) {
			return false;
		}
		else if(tmp.checkInEquipment()) {
			tmpr.setEquipId(null);
			boolean e = equipment.remove(tmp) && equipment.add(tmp);
			boolean r = reservations.remove(tmpr) && reservations.add(tmpr);
			return e && r;
		}
		else
			return false;
	}

	@Override
	public boolean updateEquipment(String eid, int flag, Object u) {
		
		Equipment tmp = null;
		for(Equipment e : equipment) {
			if(e.getEquipId().equals(eid)) {
				tmp = e;
				break;
			}
		}
		
		if(tmp == null)
			return false;
		else if(tmp.updateEquipment(flag, u)) {
			return equipment.remove(tmp) && equipment.add(tmp);
		}
		else
			return false;	

	}	
	
	
	
	
	/**
	 * Gets the RentalCenter id
	 * @return the rId
	 */
	public String getId() {
		return rId;
	}

	/**
	 * Gets the RentalCenter name
	 * @return the name of the RentalCenter
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the list of Equipment
	 * @return the equipment
	 */
	public List<Equipment> getEquipmentList() {
		return equipment;
	}
	/**
	 * Gets the list of Invoices
	 * @return the invoices
	 */
	public List<EquipmentInvoice> getInvoicesList() {
		return invoices;
	}

	/**
	 * Gets the list of RentalReservations
	 * @return the reservations
	 */
	public List<RentalReservation> getReservationsList() {
		return reservations;
	}
}
