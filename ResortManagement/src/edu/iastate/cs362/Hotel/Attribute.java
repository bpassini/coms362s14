package edu.iastate.cs362.Hotel;

public class Attribute {

		/**
		 * Number of beds in the room
		 */
		int numBeds;
		
		/**
		 * Max occupancy of the room
		 */
		int occupancy;
		
		
		/**
		 * Creates an attribute object (for a hotel room) based on the given values
		 * 
		 * @param numBeds - Number of beds in hotel room
		 * @param occupancy - Max occupancy of hotel room
		 */
		public Attribute(int numBeds, int occupancy) {
			
			this.numBeds = numBeds;
			this.occupancy = occupancy;
		}
		
}
