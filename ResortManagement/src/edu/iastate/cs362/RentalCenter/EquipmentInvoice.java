package edu.iastate.cs362.RentalCenter;

/**
 * A class representing invoices for damaged equipment.
 * 
 * @author Cameron Johnston
 * @author Bryan Passini
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
	
	/**
	 * Gets the Invoice id
	 * @return the id for the Invoice
	 */
	public String getInvoiceId() {
		return invoiceId;
	}
	
	/**
	 * Gets the corresponding Equipment id
	 * @return the id for the piece of Equipment this invoice is for
	 */
	public String getEquipId() {
		return equipId;
	}
	
	/**
	 * Gets the Invoice message
	 * @return the message of this Invoice
	 */
	public String getInvoiceMsg() {
		return msg;
	}

	@Override
	public boolean updateEquipmentInvoice(int flag, Object newInfo) {
		if(!(newInfo instanceof String))
			return false;
		switch(flag){
		case UPDATE_MESSAGE:
			msg = (String) newInfo;
			break;
		case UPDATE_EQUIPMENT_ID:
			equipId = (String) newInfo;
			break;
		default:
			return false;
		}
		return true;
	}
}
