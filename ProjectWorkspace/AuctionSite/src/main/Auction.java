package main;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Auction {

	/*public static void main(String[] args) {
		Auction auction = new Auction(); 
		//auction.InsertAuctionWithProduct("Probduct6", "Descrdgbgipdgntion", "Catsbdgegory", "Locatbvifgon", "2022-12-16 15:16:18", "10000");
		auction.getAuctions();
	}
*/
	
	public String getProductAuctionInformation(String ProductName) {
		String result = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/AuctionSite","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select `auctioned product`.ProductID, `auctioned product`.`AuctionID`, `auctioned product`.`Start`, `auctioned product`.`Ended`, `auctioned product`.`minBidPrice`, `Status`, `Approval`, `product`.`Title`, `product`.`Description`, `product`.`Category`, `product`.`Location` FROM `auctioned product`, `product` where `product`.`Title` = '" + ProductName + "';");
			rs.next();
			result = " ProductID: " + rs.getInt(1) +
					" AuctionID: " + rs.getInt(2) + 
					" Start: " + rs.getDate(3).toString() + 
					" End: " + rs.getDate(4).toString() + 
					" MinBidPrice: " + rs.getString(5) + 
					" Status: " + rs.getString(6) +
					" Approval: " + rs.getString(7) +
					" Title: " + rs.getString(8) +
					" Description: " + rs.getString(9) +
					" Category: " + rs.getString(10) +
					" Location: " + rs.getString(11)
					;
			System.out.println(result);
			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
		return result;
	}
	
	public Date addHoursToJavaUtilDate(Date date, int hours) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return (Date) calendar.getTime();
	}
	
	public void insertAuctionWithProduct(String UserID, String Title, String Description, String Category, String Location, String Start, String MinBidPrice) {
		if(Integer.parseInt(MinBidPrice) < 5000) {
			MinBidPrice = "5000";
		}
		Product product = new Product();
		product.insertProduct(UserID, Title, Description, Category, Location);
		
		if(product.getProductID() != 0) {
			insertAuction(product.getProductID() + "", Start, MinBidPrice);							
		}
	}
	
	public void insertAuction(String ProductID, String StartDate, String MinBidPrice) {
		if(Integer.parseInt(MinBidPrice) < 5000) {
			MinBidPrice = "5000";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date Start = null;
		try {
			Start = formatter.parse(StartDate);
		} catch (ParseException e1) {
			System.out.println(e1);
		} 
		Date End = addHoursToJavaUtilDate(Start, 24);
		String EndDate = formatter.format(End);
		String query = "INSERT INTO `auctioned product` (`ProductID`, `Start`, `Ended`, `minBidPrice`, `Approval`) VALUES ('" + ProductID + "', '" + StartDate + "', '" + EndDate + "', '" + MinBidPrice + "', 'False' )";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/AuctionSite","root","");
			Statement stmt=con.createStatement();
			int index = stmt.executeUpdate(query);
			if(index > 0) {
				System.out.println("Auction Data Inserted");
			}
			else {
				System.out.println("Auction Failed Insertion");
			}
			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public void updateAuctionStatus(String AuctionID, String Status, boolean Approved) {
		String Updatequery = "UPDATE `auctioned product` SET `Status` = '" + Status + "', `Approval` = '" + Approved + "' WHERE `auctioned product`.`AuctionID` = " + AuctionID;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/AuctionSite","root","");
			Statement stmt=con.createStatement();
			int index = stmt.executeUpdate(Updatequery);
			if(index > 0) {
				System.out.println("Data Updated");
			}
			else {
				System.out.println("Failed Updation");
			}
			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public String getAuctions() {
		String result = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/AuctionSite","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM `auctioned product`;");

			while(rs.next())
			{
			result += 
					" AuctionID: " + rs.getInt(1) +     
					" ProductID: " + rs.getInt(2) +
					" Start: " + rs.getDate(3).toString() + 
					" End: " + rs.getDate(4).toString() + 
					" MinBidPrice: " + rs.getString(5) + 
					" Status: " + rs.getString(6) +
					" Approval: " + rs.getString(7) + "\n"
					;
			}
			System.out.println(result);
			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
		return result;
	}

}
