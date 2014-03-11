package edu.iastate.cs362.RentalCenter;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import edu.iastate.cs362.Resort.ResortDBSupport;
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
	public boolean createRentalReservation(String rentalId, String eid, String cname,
			DateTime start, DateTime end) {
		
		RentalReservation r = new RentalReservation(rentalId, eid, cname, start, end);
		return reservations.add(r);
	}
	
	/**
	 * @return the rId
	 */
	public String getId() {
		return rId;
	}

	/**
	 * @param rId the rId to set
	 */
	public void setId(String rId) {
		this.rId = rId;
	}

	/**
	 * @return the equipment
	 */
	public List<Equipment> getEquipmentList() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipmentList(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	/**
	 * @return the invoices
	 */
	public List<EquipmentInvoice> getInvoicesList() {
		return invoices;
	}

	/**
	 * @param invoices the invoices to set
	 */
	public void setInvoicesList(List<EquipmentInvoice> invoices) {
		this.invoices = invoices;
	}

	/**
	 * @return the reservations
	 */
	public List<RentalReservation> getReservationsList() {
		return reservations;
	}

	/**
	 * @param reservations the reservations to set
	 */
	public void setReservationsList(List<RentalReservation> reservations) {
		this.reservations = reservations;
	}

	/**
	 * @return the name of the RentalCenter
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
