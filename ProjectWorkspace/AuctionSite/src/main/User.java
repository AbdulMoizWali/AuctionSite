package main;

import java.sql.*;

public class User {
	
	
	public void insertUserData(String Username, String Password, String first_name, String last_name, String phone, String address, String CNIC) {
		String insertUData = "insert INTO `user` (`Username` ,`Password` ,`First_Name`, `Last_Name`, `phone`, `Address`, `CNIC`) VALUES ('" + Username + "', '" + Password + "' ,'" + first_name + "', '" + last_name + "', '" + phone +"', '" + address + "', '" + CNIC +"')";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
			Statement stmt=con.createStatement();
			int index = stmt.executeUpdate(insertUData);
			if(index > 0) {
				System.out.println("User Data Inserted");
			}
			else {
				System.out.println("Data Insertion Failed");
			}
			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public String getUserData(String UserID) {
		
		String result = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT `Username`, `Password`, `First_Name`, `Last_Name`, `phone`, `Address`, `Balance`, `Verification_status`, `CNIC` FROM `user` WHERE UserID = '"+ UserID +"'");
			rs.next();
			result =  
					" Username: " + rs.getString(1) + 
					" Password: " + rs.getString(2) + 
					" First Name: " + rs.getString(3) + 
					" Last Name: " + rs.getString(4) +
					" phone: " + rs.getString(5) +
					" Address: " + rs.getString(6) +
					" Balance: " + rs.getString(7) +
					" Account Verfication: " + rs.getString(8) +
					" CNIC: " + rs.getString(9)
					;
//			System.out.println(result);
			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
		return result;
	}
	
	public void updateUsernamePass(String Userid, String Username, String Password, String firstname, String lastname, String phone, String Address, String Balance, String CNIC) {
		String updateUsernamePass= "UPDATE `user` SET Username = '" + Username+ "', Password = '" + Password + "', First_Name = '" + firstname +"', Last_Name = '" +lastname+ "', phone = '" + phone + "', Address = '" + Address + "', Balance = '" + Balance + "', CNIC = '" + CNIC + "' where UserID = '" + Userid + "'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
			Statement stmt=con.createStatement();
			int index = stmt.executeUpdate(updateUsernamePass);
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

	public String getloginID(String Username, String Password) {
		
		String UserID = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT `UserID` FROM `user` WHERE Username = '"+ Username +"' and Password = '" + Password + "'");
			rs.next();
			UserID =  rs.getString(1);
					

			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
		return UserID;
	}
	
	public String getProductUserData(int Sellingid) {
		String result = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT user.First_Name, user.Last_Name, user.Phone, user.Address, product.Location FROM `normal sell product` join `product` on `normal sell product`.ProductID=product.ProductID join user on product.UserID=user.UserID where SellingID = '" + Sellingid + "'");
			rs.next();
			result =  
					" First Name: " + rs.getString(1) + 
					" Last Name: " + rs.getString(2) + 
					" Phone: " + rs.getString(3) + 
					" Personal Address: " + rs.getString(4) +
					" Selling Location: " + rs.getString(5)
					;
//			System.out.println(result);
			con.close();
		} catch(Exception e)
		{
			System.out.println(e);
		}
		return result;
	}
	
}
