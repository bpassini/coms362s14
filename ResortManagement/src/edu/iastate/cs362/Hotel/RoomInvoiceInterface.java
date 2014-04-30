package edu.iastate.cs362.Hotel;

/**
 * An interface to define what needs to be implemented in the RoomInvoice class
 * 
 * @author Mike Pruszinske
 *
 */
public interface RoomInvoiceInterface {

	/**
	 * Constant used to signal that the notes variable is the field to be updated.
	 */
	static final int UPDATE_NOTES = 0;
	
	/**
	 * Constant used to signal that the room id variable is the field to be updated.
	 */
	static final int UPDATE_ROOM_ID = 1;
	
	
	/**
	 * Updates a specific field of this roomInvoice object, according to the flag
	 * @param u - the updated information object
	 * @param flag - the field we wish to update
	 * @return true if room invoice was successfully updated, false otherwise
	 */
	boolean updateRoomInvoice(Object newInfo, int flag);
	
}
