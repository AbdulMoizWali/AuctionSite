package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Product {
	private int ProductID = 0;
	private String Title;
	private String Description; 
	private String Category;
	private String Location;
	
	
	/*public static void main(String[] args) {

		Product product = new Product();
		product.InsertProduct("Title", "Description", "Category", "Location");
		product.getProducts();
	}*/
	

	
	public void insertProduct(String UserID, String Title, String Description, String Category, String Location) {
		this.Title = Title;
		this.Description = Description;
		this.Category = Category;
		this.Location = Location;
		setLatestProductID();
		if(ProductID != 0) {
			return;
		}
		//InsertProduct(Title, Description, Category, Location);			
		String Insertquery = "INSERT INTO `product` (`Title`, `Description`, `Category`, `Location`, `UserID`) VALUES ('" + Title + "', '" + Description + "', '" + Category + "', '" + Location + "', '" + UserID +"' )";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/AuctionSite","root","");
			Statement stmt=con.createStatement();
			int index = stmt.executeUpdate(Insertquery);
			if(index > 0) {
				System.out.println("Product Data Inserted");
				setLatestProductID();
			}
			else {
				System.out.println("Product Failed Insertion");
			}
			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	public void setLatestProductID() {
		String ProductSearchquery = "SELECT * FROM `product` WHERE `Title` = '" + this.Title + "' AND `Description` = '"+this.Description+"' AND `Category` = '"+this.Category+"' AND `Location` = '"+this.Location+"'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/AuctionSite","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(ProductSearchquery);
			//System.out.println(ProductSearchquery);
			if(rs != null) {
				rs.next();
				try {
					ProductID = rs.getInt(1);
				}
				catch (Exception e2){
					ProductID = 0;
				}
			}
			con.close();
		} catch(Exception e)
		{
			System.out.println(e + " setLatestProductID()");
		}
	} 
	
	
	public int getProductID() {
		return ProductID;
	}
	
	public String getProducts() {
		String result = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/AuctionSite","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM `product`");

			while(rs.next())
			{
			result += 
					" ProductID: " + rs.getInt(1) +
					" Title: " + rs.getString(2) +
					" Description: " + rs.getString(3) +
					" Category: " + rs.getString(4) +
					" Location: " + rs.getString(5) + "\n"
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
