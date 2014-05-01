package edu.iastate.cs362.Resort;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.Hotel.Hotel;
import edu.iastate.cs362.Hotel.Room;
import edu.iastate.cs362.Hotel.RoomInvoice;
import edu.iastate.cs362.Hotel.RoomReservation;
import edu.iastate.cs362.RentalCenter.Equipment;
import edu.iastate.cs362.RentalCenter.EquipmentInvoice;
import edu.iastate.cs362.RentalCenter.RentalCenter;
import edu.iastate.cs362.RentalCenter.RentalReservation;

/**
 * A class used to connect the Resort to the database, separating the database operations from the model.
 * 
 * @author Cameron Johnston
 * @author Mike Pruszinske
 * @author Bryan Passini
 *
 */
public class ResortDBSupport implements ResortDBSupportInterface {
	
	/**
	 * JDBC connection to the database
	 */
	private Connection connection = null;
	
	
	@Override
	public RentalCenter getRentalCenter(String rId) {
		
		RentalCenter rc = null;
		
		
		try {
			connection = this.getConnection();
			if(connection == null)
				rc = null;
			else {
				Statement stmt = connection.createStatement();
				Statement stmtReserv = connection.createStatement();
				Statement stmtEquip = connection.createStatement();
				Statement stmtInvoice = connection.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from RentalCenter where rId='" + rId+"'");
				
				if(rs.next()) {
					rc = new RentalCenter(rs.getString("rId"), rs.getString("rName"));
					
					ResultSet rsE = stmtEquip.executeQuery("select * from Equipment where rId='" + rId + "' order by equipId");
					ResultSet rsI = stmtInvoice.executeQuery("select * from EquipmentInvoice where rId='" + rId + "' order by invoiceId");
					ResultSet rsR = stmtReserv.executeQuery("select * from RentalReservation where rId='" + rId + "' order by rentalId");
					
					while(rsE.next()) {
						rc.addEquipment(rsE.getString("equipId"), rsE.getString("equipType"), rsE.getDouble("cost"), rsE.getString("description"), rsE.getBoolean("checkedIn"));
		
					}
					
					while(rsI.next()) {
						rc.createEquipInvoice(rsI.getString("invoiceId"),rsI.getString("equipId"),rsI.getString("msg"));
					}
					
					while(rsR.next()) {
						
						Customer customer = new Customer(rsR.getInt("cmId"), rsR.getString("firstName"), rsR.getString("lastName"));
						DateTimeFormatter df = DateTimeFormat.forPattern("MM/dd/yyyy hh::mm");
						DateTime start = df.parseDateTime((rsR.getString("startDate")));
						DateTime end = df.parseDateTime((rsR.getString("endDate")));
						
						
						rc.addRR(rsR.getString("rentalId"), rsR.getString("equipId"), customer, start, end);
					}
				}
				else {
					rc = null;
				}
				stmt.close();
				stmtReserv.close();
				stmtEquip.close();
				stmtInvoice.close();
				connection.close();
				
			}
		} 
		catch (SQLException sqle) {
				rc=null;
				sqle.printStackTrace();			
				while (sqle != null) {
					String logMessage = "\n SQL Error: "+
					  sqle.getMessage() + "\n\t\t"+
					  "Error code: "+sqle.getErrorCode() + 
	                                               "\n\t\t"+
					  "SQLState: "+sqle.getSQLState()+"\n";
			        System.out.println(logMessage);
			        sqle = sqle.getNextException();
				}
			}	
			
			return rc;
	}

	@Override
	public boolean putRentalCenter(RentalCenter rc) {
		if(this.getRentalCenter(rc.getId())==null)
			return writeRentalCenter(rc);
		else {
			updateRentalCenter(rc);
			if(rc.getEquipmentList().size()>0 || rc.getInvoicesList().size() > 0 || rc.getReservationsList().size() > 0)
				return addRCLists(rc);
			else
				return false;//trying to add a duplicate key
		}
	}	
	
	/**
	 * Writes the Rental Center to the database
	 * @param rc - the RentalCenter
	 * @return boolean value true if successful, false otherwise
	 */
	private boolean writeRentalCenter(RentalCenter rc) {
		boolean returnValue=true;
		
		try {
			connection=this.getConnection();
	           
	            String qs = "insert into RentalCenter values ('"+rc.getId()+"',"+"'"+rc.getName()
                +"')";
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(qs);
		
				// place Equipment in Database
				for(int i=0;i<rc.getEquipmentList().size();i++){
					Equipment e = rc.getEquipmentList().get(i);
					int status = (e.getStatus() == true? 1: 0);
					qs = "insert into Equipment values ('"+e.getEquipId()+"','"+ e.getEquipType()+"',"+e.getCost() + ",'"+e.getDescription()+"','" + rc.getId() + "','" + status + "')";
					stmt.executeUpdate(qs);
				}
				
				//place EquipmentInvoices in Database
				for(int j=0;j<rc.getInvoicesList().size();j++){
					EquipmentInvoice i = rc.getInvoicesList().get(j);
					qs = "insert into EquipmentInvoice values ('"+i.getInvoiceId()+"','"+ i.getEquipId()+"','"+i.getInvoiceMsg()+"','" + rc.getId() + "')";
					stmt.executeUpdate(qs);
				}
				
				//place RentalReservations in Database
				for(int j=0;j<rc.getReservationsList().size();j++){
					RentalReservation r = rc.getReservationsList().get(j);
					qs = "insert into RentalReservation values ('"+ r.getEquipId()+"','"+r.getCustomer().getCmid()+"','" + r.getCustomer().getFirstName()
							+ "','" + r.getCustomer().getLastName()+ "','" + r.getStart().toString()+"','" + r.getEnd().toString()+"','"+r.getRentalId()+"','" + rc.getId() + "')";
					stmt.executeUpdate(qs);
				}


				stmt.close();
				connection.close();
		} catch (SQLException sqle){
			returnValue=false;
			sqle.printStackTrace();			
			while (sqle != null) {
				String logMessage = "\n SQL Error: "+
				  sqle.getMessage() + "\n\t\t"+
				  "Error code: "+sqle.getErrorCode() + 
                                               "\n\t\t"+
				  "SQLState: "+sqle.getSQLState()+"\n";
		        System.out.println(logMessage);
		        sqle = sqle.getNextException();
			}
		}
		
		return returnValue;
	}
	
	/**
	 * If the RentalCenter already exists, just update the Lists in the tables
	 * @param rc - the RentalCenter with lists
	 * @return boolean value true if successful, false otherwise
	 */
	private boolean addRCLists(RentalCenter rc) {
		
		boolean returnValue=true;
		
		try {
			  connection=this.getConnection();
			  if(connection==null)
				returnValue=false;
			  else{
				  //create statements 
				Statement stmt = connection.createStatement();
				Statement stmtERead = connection.createStatement();
				Statement stmtEWrite = connection.createStatement();
				Statement stmtIRead = connection.createStatement();
				Statement stmtIWrite = connection.createStatement();
				Statement stmtRRead = connection.createStatement();
				Statement stmtRWrite = connection.createStatement();
				
				ResultSet rsERead = stmtERead.executeQuery("select count(*) as count1 from Equipment where rId='" + rc.getId() + "'");
				ResultSet rsIRead = stmtIRead.executeQuery("select count(*) as count2 from EquipmentInvoice where rId='" + rc.getId() + "'");
				ResultSet rsRRead = stmtRRead.executeQuery("select count(*) as count3 from RentalReservation where rId='" + rc.getId() + "'");
				
				rsERead.next();
				int eCount = rsERead.getInt("count1");
				rsIRead.next();
				int iCount = rsIRead.getInt("count2");
				rsRRead.next();
				int rCount = rsRRead.getInt("count3");
				
				//there has been a change to EquipmentList, so add the last one to the Database
				if(rc.getEquipmentList().size() - eCount == 1) {
					Equipment e = rc.getEquipmentList().get(rc.getEquipmentList().size()-1);
					int status = (e.getStatus() == true? 1: 0);
					stmtEWrite.executeUpdate("insert into Equipment values ('"+e.getEquipId()+"','"+ e.getEquipType()+"',"+e.getCost() + ",'"+e.getDescription()+"','" + rc.getId()+ "','" + status +"')");
				}
				else if(rc.getEquipmentList().size() - eCount == 0 && rc.getEquipmentList().size() != 0) {
					Equipment e = rc.getEquipmentList().get(rc.getEquipmentList().size()-1);
					int status = (e.getStatus() == true? 1: 0);
					stmtEWrite.executeUpdate("update Equipment set equipType='"+ e.getEquipType() + "', cost='" + e.getCost() + "', description='" + e.getDescription() + "', rId='" + rc.getId() + "', checkedIn=" + status + " where equipId='" + e.getEquipId() + "'");
				}
				
				//there has been a change to InvoicesList, so add the last one to the Database
				if(rc.getInvoicesList().size() - iCount == 1) {
					EquipmentInvoice i = rc.getInvoicesList().get(rc.getInvoicesList().size()-1);
					stmtIWrite.executeUpdate("insert into EquipmentInvoice values ('"+i.getInvoiceId()+"','"+ i.getEquipId()+"','"+i.getInvoiceMsg()+"','" + rc.getId() + "')");
				}
				else if(rc.getInvoicesList().size() - iCount == 0 && rc.getInvoicesList().size() != 0) {
					EquipmentInvoice i = rc.getInvoicesList().get(rc.getInvoicesList().size()-1);
					stmtIWrite.executeUpdate("update EquipmentInvoice set equipId='"+ i.getEquipId() + "', msg='" + i.getInvoiceMsg() + "', rId='" + rc.getId() + "' where invoiceId='" + i.getInvoiceId() + "'");
				}
				
				DateTimeFormatter df = DateTimeFormat.forPattern("MM/dd/yyyy hh::mm");
				//there has been a change to ReservationsList, so add the last one to the Database
				if(rc.getReservationsList().size() - rCount == 1) {
					RentalReservation r = rc.getReservationsList().get(rc.getReservationsList().size() - 1);
					stmtRWrite.executeUpdate("insert into RentalReservation values ('" +r.getRentalId()+"','" + r.getEquipId()+"','"+r.getCustomer().getCmid()+"','" + r.getCustomer().getFirstName()
							+ "','" + r.getCustomer().getLastName()+ "','" + r.getStart().toString(df)+"','" + r.getEnd().toString(df)+"','" + rc.getId() + "')");
				}
				else if(rc.getReservationsList().size() - rCount == 0 && rc.getReservationsList().size() != 0) {
					RentalReservation r = rc.getReservationsList().get(rc.getReservationsList().size() - 1);
					stmtRWrite.executeUpdate("update RentalReservation set equipId='"+ r.getEquipId() + "', cmId='" + r.getCustomer().getCmid() + "', firstName='" + r.getCustomer().getFirstName() + "', lastName='" + r.getCustomer().getLastName() + "', startDate='" + r.getStart().toString(df)
							+ "', endDate='" + r.getEnd().toString(df) + "', rId='" + rc.getId() + "' where rentalId='" + r.getRentalId() + "'");
				}
				
				//close statements and connections
				stmt.close();
				stmtERead.close();
				stmtEWrite.close();
				stmtIRead.close();
				stmtIWrite.close();
				stmtRRead.close();
				stmtRWrite.close();
				connection.close();
			  }
		} catch (SQLException sqle){
			returnValue=false;
			sqle.printStackTrace();			
			while (sqle != null) {
				String logMessage = "\n SQL Error: "+
				  sqle.getMessage() + "\n\t\t"+
				  "Error code: "+sqle.getErrorCode() + 
                                               "\n\t\t"+
				  "SQLState: "+sqle.getSQLState()+"\n";
		        System.out.println(logMessage);
		        sqle = sqle.getNextException();
			}

		}
		return returnValue;
	}

	private void updateRentalCenter(RentalCenter rc) {
		try {
			connection=this.getConnection();
			if(connection==null)
				return;
			else{
				Statement stmt = connection.createStatement();
				stmt.executeUpdate("update RentalCenter set rName='"+ rc.getName() + "'");
			}
		}
		 catch (SQLException sqle){
				sqle.printStackTrace();			
				while (sqle != null) {
					String logMessage = "\n SQL Error: "+
					  sqle.getMessage() + "\n\t\t"+
					  "Error code: "+sqle.getErrorCode() + 
	                                               "\n\t\t"+
					  "SQLState: "+sqle.getSQLState()+"\n";
			        System.out.println(logMessage);
			        sqle = sqle.getNextException();
				}
		 }
	}
	@Override
	public Hotel getHotel(String hid) {
		
		Hotel h = null;
		DateTimeFormatter f = DateTimeFormat.forPattern("MM/dd/yyyy");
		
		try {
			connection = this.getConnection();
			if(connection == null)
				h = null;
			else {
				Statement stmt = connection.createStatement();
				Statement stmtRoom = connection.createStatement();
				Statement stmtReserv = connection.createStatement();
				Statement stmtInvoice = connection.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from Hotel where HotelId='" + hid +"'");
				
				if(rs.next()) {
					h = new Hotel(rs.getString("HotelId"), rs.getString("HotelName"));
					
					ResultSet rsRooms = stmtRoom.executeQuery("select * from Rooms where HotelId='" + hid + "' order by RoomId");
					ResultSet rsReservations = stmtInvoice.executeQuery("select * from RoomReservations where HotelId='" + hid + "' order by RoomReservationID");
					ResultSet rsInvoices = stmtReserv.executeQuery("select * from RoomInvoices where HotelId='" + hid + "' order by RoomInvoiceID");						
					
					ArrayList<String> beds = new ArrayList<String>();
					if(rsRooms.next())
					{
						String[] bedsSplit = rsRooms.getString("BedTypes").split(", ");
						for(int i=0; i<bedsSplit.length; i++)
						{
							beds.add(bedsSplit[i]);
						}
						
						h.addRoom(beds, rsRooms.getInt("Occupancy"), rsRooms.getString("Description"), rsRooms.getInt("RoomID"));
					}
					
					while(rsReservations.next()) {
						
						Customer cust = new Customer(rsReservations.getInt("CustomerID"), rsReservations.getString("FirstName"), rsReservations.getString("LastName"));
						DateTime start = DateTime.parse(rsReservations.getString("StartDate"), f);
						DateTime end = DateTime.parse(rsReservations.getString("EndDate"), f);
						int rmid = rsReservations.getInt("RoomID");
						
					// No longer need due to modified room reservation creation
					/*
						ArrayList<String> bedsReservation = new ArrayList<String>();
						String[] bedsReservationSplit = rsReservations.getString("BedTypes").split(", ");
						for(int i=0; i<bedsReservationSplit.length; i++)
						{
							bedsReservation.add(bedsReservationSplit[i]);
						}
					
						int numGuests = rsReservations.getInt("NumGuests");
						
						Attribute attr = new Attribute(bedsReservation, numGuests);
					*/	
						h.createRoomReservation(rsReservations.getString("RoomReservationID"), start, end, cust, rmid);
					}
					
					while(rsInvoices.next()) {
						
						h.createRoomInvoice(rsInvoices.getInt("RoomID"), rsInvoices.getString("RoomInvoiceID"), rsInvoices.getString("Notes"));
					}
				}
				
				else {
					h = null;
				}
				
				stmt.close();
				stmtRoom.close();
				stmtReserv.close();
				stmtInvoice.close();
				connection.close();
				
			}
		} 
		catch (SQLException sqle) {
				h=null;
				sqle.printStackTrace();			
				while (sqle != null) {
					String logMessage = "\n SQL Error: "+
					  sqle.getMessage() + "\n\t\t"+
					  "Error code: "+sqle.getErrorCode() + 
	                                               "\n\t\t"+
					  "SQLState: "+sqle.getSQLState()+"\n";
			        System.out.println(logMessage);
			        sqle = sqle.getNextException();
				}
			}	
			
			return h;
	}

	@Override
	public boolean putHotel(Hotel h) {
		
		if(this.getHotel(h.getID())==null)
			return writeHotel(h);
		else
			if(h.getRoomsList().size() > 0 || h.getReservationsList().size() > 0 || h.getInvoicesList().size() > 0)
				return addHotelLists(h);
			else
				return false;	// trying to add a duplicate key
	}
	
	/**
	 * Writes the hotel to the database
	 * 
	 * @param h - Hotel
	 * @return true if successful, false otherwise
	 */
	private boolean writeHotel(Hotel h) {
		
		boolean returnValue=true;
		
		// Uses the try/catch block to determine if there was an error.
		// The boolean returnValue begins as true and will only be set to 
		// false if there is an SQL error (exception).
		
		try {
			
			System.out.println("WRITING RENTAL CENTER.");
			connection=this.getConnection();
	           
	            String qs = "insert into Hotel values ('"+ h.getID() +"',"+"'"+ h.getName() +"')";
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(qs);
				
				for(int i=0; i<h.getRoomsList().size(); i++) {
					Room r = h.getRoomsList().get(i);
					qs = "insert into Rooms values ('"+r.getRoomID()+"','"+h.getID()+"','"+r.getOccupancy()+"','"+r.getBeds().size()+"','"+r.getDescription()+"','"+r.getBeds().toString()+"', '"+r.getStatus()+"')";
					stmt.executeUpdate(qs);
				}
				
				DateTimeFormatter f = DateTimeFormat.forPattern("MM/dd/yyyy");
				for(int j=0; j<h.getReservationsList().size(); j++){
					RoomReservation r = h.getReservationsList().get(j);
					qs = "insert into RoomReservations values ('"+r.getRoomReservationID()+"','"+r.getStart().toString(f)+"','"+r.getEnd().toString(f)
							+ "','" + r.getCustomerID()+ "','" + r.getFirstName()+ "','" + r.getLastName()+ "','" + r.getHotelID()+"','" + r.getRoomID() + "')";
					stmt.executeUpdate(qs);
				}
				
				for(int j=0; j<h.getInvoicesList().size(); j++){
					RoomInvoice i = h.getInvoicesList().get(j);
					qs = "insert into RoomInvoices values ('"+i.getHotelID()+"','"+ i.getRoomID()+"','"+i.getRoomInvoiceID()+"','"+ i.getNotes()+"')";
					stmt.executeUpdate(qs);
				}

				stmt.close();
				connection.close();
				
		} catch (SQLException sqle){
			returnValue=false;
			sqle.printStackTrace();			
			while (sqle != null) {
				String logMessage = "\n SQL Error: "+
				  sqle.getMessage() + "\n\t\t"+
				  "Error code: "+sqle.getErrorCode() + 
                                               "\n\t\t"+
				  "SQLState: "+sqle.getSQLState()+"\n";
		        System.out.println(logMessage);
		        sqle = sqle.getNextException();
			}
		}
		
		return returnValue;
	}

	/**
	 * If the Hotel already exists, just updates the lists in the tables
	 * 
	 * @param h - Hotel (with lists)
	 * @return true if successful, false otherwise
	 */
	private boolean addHotelLists(Hotel h) {
		
		boolean returnValue=true;
		
		// We use the try/catch block to determine if there was an error.
		// The boolean returnValue starts out as true and will only be set to 
		// false if there is an SQL error (exception).
		
		try {
			  connection=this.getConnection();
			  if(connection==null)
				returnValue=false;
			  
			  else{
				Statement stmt = connection.createStatement();
				Statement stmtRoomRead = connection.createStatement();
				Statement stmtRoomWrite = connection.createStatement();
				Statement stmtReservRead = connection.createStatement();
				Statement stmtReservWrite = connection.createStatement();
				Statement stmtInvoiceRead = connection.createStatement();
				Statement stmtInvoiceWrite = connection.createStatement();
				
				ResultSet rsRoomRead = stmtRoomRead.executeQuery("select count(*) as count1 from Rooms where HotelId='" + h.getID() + "'");
				ResultSet rsReservRead = stmtReservRead.executeQuery("select count(*) as count2 from RoomReservations where HotelId='" + h.getID() + "'");
				ResultSet rsInvoiceRead = stmtInvoiceRead.executeQuery("select count(*) as count3 from RoomInvoices where HotelId='" + h.getID() + "'");

				
				rsRoomRead.next();
				int roomCount = rsRoomRead.getInt("count1");
				rsReservRead.next();
				int reservCount = rsReservRead.getInt("count2");
				rsInvoiceRead.next();
				int invoiceCount = rsInvoiceRead.getInt("count3");
				
				if(h.getRoomsList().size() - roomCount == 1) {
					Room r = h.getRoomsList().get(h.getRoomsList().size()-1);
					int occupied = (r.getStatus() == true? 1: 0);
					stmtRoomWrite.executeUpdate("insert into Rooms values ('"+r.getRoomID()+"','"+h.getID()+"','"+r.getOccupancy()+"','"+r.getBeds().size()+"','"+r.getDescription()+"','"+r.getBeds().toString()+"', '"+ occupied +"')");
				}
				else if(h.getRoomsList().size() - roomCount == 0) {
					Room r = h.getRoomsList().get(h.getRoomsList().size()-1);
					int occupied = (r.getStatus() == true? 1: 0);
					stmtRoomWrite.executeUpdate("update Rooms set HotelID='" + h.getID() + "', Occupancy='" + r.getOccupancy() + "', NumBeds='" + r.getBeds().size() + "', Description='" + r.getDescription() + "', BedTypes='"
					+ r.getBeds().toString().replace("[", "").replace("]", "") + "', Occupied='" + occupied + "' where RoomID='" + r.getRoomID() + "'");
				}
				
				
				DateTimeFormatter f = DateTimeFormat.forPattern("MM/dd/yyyy");
				if(h.getReservationsList().size() - reservCount == 1) {
					RoomReservation r = h.getReservationsList().get(h.getReservationsList().size()-1);					
					stmtReservWrite.executeUpdate("insert into RoomReservations values ('"+r.getRoomReservationID()+"','"+r.getStart().toString(f)+"','"+r.getEnd().toString(f)
					+ "','" + r.getCustomerID()+ "','" + r.getFirstName()+ "','" + r.getLastName()+ "','" + r.getHotelID()+"','" + r.getRoomID() + "')");
				}
				else if(h.getReservationsList().size() - reservCount == 0) {
					RoomReservation r = h.getReservationsList().get(h.getReservationsList().size()-1);
					stmtReservWrite.executeUpdate("update RoomReservations set StartDate='" + r.getStart().toString(f) + "', EndDate='" + r.getEnd().toString(f) + "', CustomerID='" + r.getCustomerID() + "', FirstName='" + r.getFirstName() +
							"', LastName='" + r.getLastName() + "', HotelID='" + r.getHotelID() + "', RoomID='" + r.getRoomID() + "' where RoomReservationID='" + r.getRoomReservationID() + "'");
				}
				
				if(h.getInvoicesList().size() - invoiceCount == 1) {
					RoomInvoice i = h.getInvoicesList().get(h.getInvoicesList().size()-1);
					stmtInvoiceWrite.executeUpdate("insert into RoomInvoices values ('"+i.getHotelID()+"','"+ i.getRoomID()+"','"+i.getRoomInvoiceID()+"','"+ i.getNotes()+"')");
				}
				else if(h.getInvoicesList().size() - invoiceCount == 0) {
					RoomInvoice i = h.getInvoicesList().get(h.getInvoicesList().size()-1);
					stmtInvoiceWrite.executeUpdate("update RoomInvoices set RoomID='"+ i.getHotelID() + "', Notes='" + i.getNotes() + "', RoomID='" + i.getRoomID() + "' where RoomInvoiceID='" + i.getRoomInvoiceID() + "'");
				}
				
				stmt.close();
				stmtRoomRead.close();
				stmtRoomWrite.close();
				stmtReservRead.close();
				stmtReservWrite.close();
				stmtInvoiceRead.close();
				stmtInvoiceWrite.close();
				connection.close();
			  }
			  
		} catch (SQLException sqle){
			returnValue=false;
			sqle.printStackTrace();			
			while (sqle != null) {
				String logMessage = "\n SQL Error: "+
				  sqle.getMessage() + "\n\t\t"+
				  "Error code: "+sqle.getErrorCode() + 
                                               "\n\t\t"+
				  "SQLState: "+sqle.getSQLState()+"\n";
		        System.out.println(logMessage);
		        sqle = sqle.getNextException();
			}

		}
		
		return returnValue;
	}

	/**
	 * makes a JDBC connection to our database
	 * @return the Connection to the database
	 */
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://mysql.cs.iastate.edu/db36202";
			String username = "u36202";
			String password = "K5f7k9eyw";
			
			connection = DriverManager.getConnection(url, username, password);
		}
		catch(ClassNotFoundException nfe) {
			connection = null;
		}
		catch(SQLException sqle) {
			connection = null;
		}
		
		return connection;
	}

}
