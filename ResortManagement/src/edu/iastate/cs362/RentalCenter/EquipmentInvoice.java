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
	private String invoiceId;
	/**
	 * The id for the corresponding equipment of this invoice. 
	 */
	private String equipId;
	
	/**
	 * The message of the invoice. 
	 */
	private String msg;
	
	/**
	 * Creates a new Equipment Invoice object. 
	 * @param invoiceId -  The id for this invoice.
	 * @param equipId - The id for the corresponding equipment of this invoice. 
	 * @param msg - The message of the invoice. 
	 */
	public EquipmentInvoice(String invoiceId, String equipId, String msg) {
		this.invoiceId = invoiceId;
		this.equipId = equipId;
		this.msg = msg;
	}
	
	public String getInvoiceId() {
		return invoiceId;
	}
	
	public String getEquipId() {
		return equipId;
	}
	
	public String getInvoiceMsg() {
		return msg;
	}

	public void setInvoiceMsg(String msg) {
		this.msg = msg;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	
	
}
