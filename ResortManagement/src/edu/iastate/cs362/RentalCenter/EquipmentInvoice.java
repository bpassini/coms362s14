package edu.iastate.cs362.RentalCenter;

/**
 * A class representing invoices for damaged equipment.
 * 
 * @author Cameron Johnston
 *
 */
public class EquipmentInvoice implements EquipmentInvoiceInterface {
	
	/** 
	 *  The id for this invoice.
	 */
	private String id;
	/**
	 * The id for the corresponding equipment of this invoice. 
	 */
	private String eId;
	
	/**
	 * The message of the invoice. 
	 */
	private String msg;
	
	/**
	 * Creates a new Equipment Invoice object. 
	 * @param id -  The id for this invoice.
	 * @param eId - The id for the corresponding equipment of this invoice. 
	 * @param msg - The message of the invoice. 
	 */
	public EquipmentInvoice(String id, String eId, String msg) {
		this.id = id;
		this.eId = eId;
		this.msg = msg;
	}
	
	//TODO add getter and setter methods
}
