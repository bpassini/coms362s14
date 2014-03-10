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
	
}
