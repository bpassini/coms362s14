package edu.iastate.cs362.Hotel;

/**
 * Represents a room invoice for a hotel room
 * 
 * @author Mike Pruszinske
 *
 */
public class RoomInvoice implements RoomInvoiceInterface {
	
	/**
	 * Hotel ID
	 */
	String hid;
	
	/**
	 * Hotel room ID
	 */
	int rmid;
	
	/**
	 * Invoice ID
	 */
	String iid;
	
	/**
	 * Summary of issue & additional notes
	 */
	String notes;
	
	
	/**
	 * Creates a room invoice with the given parameters
	 * 
	 * @param hid - Hotel ID
	 * @param rmid - Room ID
	 * @param iid - Invoice ID
	 * @param notes - Description of the issue or notes
	 */
	public RoomInvoice(String hid, int rmid, String iid, String notes) {
		
		this.hid = hid;
		this.rmid = rmid;
		this.iid = iid;
		this.notes = notes;
	}
	
	
	@Override
	public boolean updateRoomInvoice(Object newInfo, int flag) {
		
		if(!(newInfo instanceof String || newInfo instanceof Integer))
			return false;
		
		switch(flag) {
		
			case UPDATE_NOTES:
				notes = (String) newInfo;
				break;
				
			case UPDATE_ROOM_ID:
				rmid = (int) newInfo;
				break;
				
			default:
				return false;
		}
		
		return true;
	}
	
	
	public String getHotelID() {
		return hid;
	}
	
	public void setHotelID(String hid) {
		this.hid = hid;
	}
	
	public int getRoomID() {
		return rmid;
	}
	
	public void setRoomID(int rmid) {
		this.rmid = rmid;
	}
	
	public String getRoomInvoiceID() {
		return iid;
	}
	
	public void setRoomInvoiceID(String iid) {
		this.iid = iid;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
