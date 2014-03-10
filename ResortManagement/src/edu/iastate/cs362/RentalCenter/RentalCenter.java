package edu.iastate.cs362.RentalCenter;

import java.util.ArrayList;

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
	 * Creates a new RentalCenter object.
	 * @param id - The id for this Rental Center.
	 * @param name - The name of this Rental Center.
	 */
	
	private ArrayList<Equipment> equipment;
	private ArrayList<EquipmentInvoice> invoices;
	private ArrayList<RentalReservation> reservations;
	
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
		equipment.add(e);
		return (new ResortDBSupport().putRentalCenter(this));
	}

	@Override
	public boolean createEquipInvoice(String invoiceId, String eid, String msg) {
		
		EquipmentInvoice i = new EquipmentInvoice(invoiceId, eid, msg);
		invoices.add(i);
		return (new ResortDBSupport().putRentalCenter(this));
	}

	@Override
	public boolean createRentalReservation(String rentalId, String eid, String cname,
			DateTime start, DateTime end) {
		
		RentalReservation r = new RentalReservation(rentalId, eid, cname, start, end);
		reservations.add(r);
		return (new ResortDBSupport().putRentalCenter(this));
	}
	
	//TODO add getter and setter methods

}
