package edu.iastate.cs362.RentalCenter;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import edu.iastate.cs362.Hotel.Customer;
/**
 * Class representing a RentalCenter.  Our resort can own many different RentalCenters.
 * @author Cameron Johnston
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
			String description) {
		
		Equipment e = new Equipment(eid, equipType, cost, description);
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
