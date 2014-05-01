package edu.iastate.cs362.RentalCenter;

import java.util.ArrayList;
import java.util.HashMap;
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
		List<Equipment> eq = checkEquipmentAvailability(start, end);
		boolean found = false;
		for(Equipment e: eq) {
			if(e.getEquipId().equals(eid)) {
				found = true;
				break;
			}
		}
		
		if(found) {
			RentalReservation r = new RentalReservation(rentalId, eid, cust, start, end);
			return reservations.add(r);
		}
		else
			return false;
	}
	
	public boolean addRR(String rentalId, String eid, Customer cust, DateTime start, DateTime end) {
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
	public boolean checkOutEquipment(String rentalId) {
		
		
		RentalReservation tmpr = null;
		for(RentalReservation r: reservations) {
			if(r.getRentalId().equals(rentalId)) {
				tmpr = r;
				break;
			}
		}
		
		if(tmpr == null) {
			return false;
		}
		
		String eID = tmpr.getEquipId();
		Equipment tmp = null;
		for(Equipment e : equipment) {
			if(e.getEquipId().equals(eID)) {
				tmp = e;
				break;
			}
		}
		if(tmp != null && tmp.checkOutEquipment()) {
			boolean e = equipment.remove(tmp) && equipment.add(tmp);
			boolean r = reservations.remove(tmpr) && reservations.add(tmpr);
			return e && r;
		}
		else
			return false;
		
	}

	@Override
	public boolean checkInEquipment( String rentalId) {
		
		RentalReservation tmpr = null;
		for(RentalReservation r: reservations) {
			if(r.getRentalId().equals(rentalId)) {
				tmpr = r;
				break;
			}
		}
		
		if(tmpr == null) {
			return false;
		}
		
		String eID = tmpr.getEquipId();
		Equipment tmp = null;
		for(Equipment e : equipment) {
			if(e.getEquipId().equals(eID)) {
				tmp = e;
				break;
			}
		}
		
		if(tmp != null && tmp.checkInEquipment()) {
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

	@Override
	public List<Equipment> searchEquipment(Object s, int flag) {
		List<Equipment> e = new ArrayList<Equipment>();
		boolean found = false;
		if(flag == SEARCH_BY_ID) {
			if(s instanceof String) {
				String id = (String) s;
				for(Equipment eq : equipment) {
					if(eq.getEquipId().equals(id)) {
						e.add(eq);
						found = true;
						break;
					}
				}
			}
		}
		else if(flag == SEARCH_BY_TYPE) {
			if(s instanceof String) {
				String type = (String) s;
				for(Equipment eq : equipment) {
					if(eq.getEquipType().equalsIgnoreCase(type)) {
						e.add(eq);
						found = true;
					}
				}
			}
		}
		else if(flag == SEARCH_BY_COST) {
			if(s instanceof Double) {
				double cost = (double) s;
				for(Equipment eq : equipment) {
					if(eq.getCost() == cost) {
						e.add(eq);
						found = true;
					}
				}
			}
		}
		else if(flag == SEARCH_BY_STATUS) {
			if(s instanceof Boolean) {
				boolean status = (boolean) s;
				for(Equipment eq : equipment) {
					if(eq.getStatus() == status) {
						e.add(eq);
						found = true;
					}
				}
			}
		}
		
		if(!found)
			return null;
		else
			return e;
	}

	@Override
	public List<Equipment> checkEquipmentAvailability(DateTime startDate,
			DateTime endDate) {
		//contains ids of equipment that are not available
		List<String> ids = new ArrayList<String>();
		//be careful here, not sure if it copies it
		List<Equipment> availEquip = new ArrayList<Equipment>();
		availEquip.addAll(equipment);
		
		
		for(RentalReservation rr: reservations) {
			
			if( startDate.isEqual(rr.getStart()) || (startDate.isAfter(rr.getStart()) && startDate.isBefore(rr.getEnd())) || 
					endDate.isEqual(rr.getEnd()) || (endDate.isAfter(rr.getStart()) && endDate.isBefore(rr.getEnd())) || 
						(startDate.isBefore(rr.getStart()) && endDate.isAfter(rr.getEnd())) ) {
				
				if(!ids.contains(rr.getEquipId())) {
					ids.add(rr.getEquipId());
				}
			}
			else if(ids.contains(rr.getEquipId())) {
				ids.remove(rr.getEquipId());
			}
		}
		
		
		for(String id: ids) {
			for(Equipment e: equipment) {
				if(e.getEquipId().equals(id)) {
					availEquip.remove(e);
				}
			}
		}
		
		return availEquip;
	}
}
