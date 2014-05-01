package edu.iastate.cs362.Resort;

import java.util.Scanner;

import edu.iastate.cs362.Hotel.HotelView;
import edu.iastate.cs362.ManagementSystem.ManagementSystemView;
import edu.iastate.cs362.RentalCenter.RentalCenterUI;

public class ResortUI {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while(true) {
			
			System.out.println("Which system would you like to use?\n 1. Hotel\n 2. Rental Center\n 3. ManagementCenter\n 4. Exit\n");
			int code = -1;
			code = Integer.parseInt(in.nextLine().trim());
			
			if(code == 1) {
				HotelView.main(null);
			}
			else if(code == 2) {
				
				RentalCenterUI.main(null);
			}
			else if(code == 3) {
				ManagementSystemView.main(null);
			}
		}
			
	}
	
}
