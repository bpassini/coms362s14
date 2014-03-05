package edu.iastate.cs362.Hotel;

public interface HotelDBSupportInterface {
	boolean putRoomInvoice(RoomInvoice i);
	boolean putRoom(Room r);
	boolean putRoomReservation(RoomReservation rr);
}
