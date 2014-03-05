package edu.iastate.cs362.iteration1;

public interface HotelDBSupportInterface {
	boolean putRoomInvoice(RoomInvoice i);
	boolean putRoom(Room r);
	boolean putRoomReservation(RoomReservation rr);
}
