package edu.iastate.cs362.Resort;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import edu.iastate.cs362.Hotel.Customer;
import edu.iastate.cs362.Hotel.Hotel;
import edu.iastate.cs362.RentalCenter.Equipment;
import edu.iastate.cs362.RentalCenter.EquipmentInvoice;
import edu.iastate.cs362.RentalCenter.RentalCenter;
import edu.iastate.cs362.RentalCenter.RentalReservation;

public class ResortDBSupport implements ResortDBSupportInterface {
	
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
						rc.addEquipment(rsE.getString("equipId"), rsE.getString("equipType"), rsE.getDouble("cost"), rsE.getString("description"));
					}
					
					while(rsI.next()) {
						rc.createEquipInvoice(rsI.getString("invoiceId"),rsI.getString("equipId"),rsI.getString("msg"));
					}
					
					while(rsR.next()) {
						
						Customer customer = new Customer(rsR.getInt("cmId"), rsR.getString("firstName"), rsR.getString("lastName"));
						DateTimeFormatter df = DateTimeFormat.forPattern("dd/MM/yyyy hh::mm");
						DateTime start = df.parseDateTime((rsR.getString("startDate")));
						DateTime end = df.parseDateTime((rsR.getString("endDate")));
						
						rc.createRentalReservation(rsR.getString("rentalId"), rsR.getString("equipId"), customer, start, end);
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
		else
			if(rc.getEquipmentList().size()>0 || rc.getInvoicesList().size() > 0 || rc.getReservationsList().size() > 0)
				return addRCLists(rc);
			else
				return false;//trying to add a duplicate key
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
		
				
				for(int i=0;i<rc.getEquipmentList().size();i++){
					Equipment e = rc.getEquipmentList().get(i);
					qs = "insert into Equipment values ('"+e.getEquipId()+"','"+ e.getEquipType()+"',"+e.getCost() + ",'"+e.getDescription()+"')";
					stmt.executeUpdate(qs);
				}
				
				for(int j=0;j<rc.getInvoicesList().size();j++){
					EquipmentInvoice i = rc.getInvoicesList().get(j);
					qs = "insert into EquipmentInvoice values ('"+i.getInvoiceId()+"','"+ i.getEquipId()+"','"+i.getInvoiceMsg()+"')";
					stmt.executeUpdate(qs);
				}
				
				for(int j=0;j<rc.getReservationsList().size();j++){
					RentalReservation r = rc.getReservationsList().get(j);
					qs = "insert into RentalReservation values ('"+ r.getEquipId()+"','"+r.getCustomer().getCmid()+"','" + r.getCustomer().getFirstName()
							+ "','" + r.getCustomer().getLastName()+ "','" + r.getStart().toString()+"','" + r.getEnd().toString()+"','"+r.getRentalId()+"')";
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
				
				if(rc.getEquipmentList().size() - eCount == 1) {
					Equipment e = rc.getEquipmentList().get(rc.getEquipmentList().size()-1);
					stmtEWrite.executeUpdate("insert into Equipment values ('"+e.getEquipId()+"','"+ e.getEquipType()+"',"+e.getCost() + ",'"+e.getDescription()+"','" + rc.getId()+ "')");
				}
				
				if(rc.getInvoicesList().size() - iCount == 1) {
					EquipmentInvoice i = rc.getInvoicesList().get(rc.getInvoicesList().size()-1);
					stmtIWrite.executeUpdate("insert into EquipmentInvoice values ('"+i.getInvoiceId()+"','"+ i.getEquipId()+"','"+i.getInvoiceMsg()+"','" + rc.getId() + "')");
				}
				
				DateTimeFormatter df = DateTimeFormat.forPattern("dd/MM/yyyy hh::mm");
				if(rc.getReservationsList().size() - rCount == 1) {
					RentalReservation r = rc.getReservationsList().get(rc.getReservationsList().size() - 1);
					stmtRWrite.executeUpdate("insert into RentalReservation values ('" +r.getRentalId()+"','" + r.getEquipId()+"','"+r.getCustomer().getCmid()+"','" + r.getCustomer().getFirstName()
							+ "','" + r.getCustomer().getLastName()+ "','" + r.getStart().toString(df)+"','" + r.getEnd().toString(df)+"','" + rc.getId() + "')");
				}
				
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

	@Override
	public Hotel getHotel(String hid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean putHotel(Hotel h) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * makes a connection to our database
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
