package edu.iastate.cs362.Hotel;

public class Room implements RoomInterface {
	
	/**
	 * Hotel room ID
	 */
	int rmid;
	
	/**
	 * Attribute object (containing numBeds, occupancy, hasKitchen, and handicapAccess)
	 */
	Attribute attr;
	
	/**
	 * Description of room
	 */
	String desc;
	
	
	/**
	 * Creates a new hotel room according to the given parameters
	 * 
	 * @param rmid - Room ID
	 * @param attr - Attribute object containing room attributes
	 * @param desc - Description of room
	 */
	public Room(int rmid, Attribute attr, String desc) {
		
		this.rmid = rmid;
		this.attr = attr;
		this.desc = desc;
	}
	
}
