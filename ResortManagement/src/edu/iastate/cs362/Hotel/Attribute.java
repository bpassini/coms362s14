package edu.iastate.cs362.Hotel;

import java.util.ArrayList;

public class Attribute {

		/**
		 * Number and type of beds
		 * size of ArrayList = # of beds
		 * value at each index = bed size (King, Queen, or Twin)
		 */
		ArrayList<String> beds;
		
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
		public Attribute(ArrayList<String> beds, int occupancy) {
			
			this.beds = beds;
			this.occupancy = occupancy;
		}
		
}
