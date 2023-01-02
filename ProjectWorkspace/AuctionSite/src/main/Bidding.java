package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDateTime;    
public class Bidding {

	
	public String getProduct(int Productid)
	{

	    String result = "";
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con =
	        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
	        Statement stmt=con.createStatement();
	        String view="SELECT product.Title,product.Category,product.Description,product.Location,`auctioned product`.Ended,`auctioned product`.Status,user.First_Name,`user buy auction`.BidAmount from product JOIN `auctioned product` on product.ProductID =`auctioned product`.ProductID  join `user buy auction` on `auctioned product`.`AuctionID` =`user buy auction`.`AuctionID` join user on `user buy auction`.`UserID`=user.UserID where `user buy auction`.`AuctionID`="+Productid+";";
	        ResultSet rs=stmt.executeQuery(view);

	        while(rs.next())
	        {
	        result += 
	                "Title: " + rs.getString(1) +
	                "\nCateogry: " + rs.getString(2) +
	                "\nDescription: " + rs.getString(3) +
	                "\nLocation: " + rs.getString(4) + 
	                "\nEnded: " + rs.getString(5) +
	                "\nStatus: " + rs.getString(6) +
	                "\nBidder: " + rs.getString(7) +
	                "\nBid: " + rs.getString(8) ;
	              
	        }
	        System.out.println(result);
	        con.close();
	    } catch(Exception e)
	    {
	        System.out.println(e);
	    }
	    return result; 
	}
	
	
	public String getenddate(int AuctionID)
	{

	    String result = "";
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con =
	        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
	        Statement stmt=con.createStatement();
	        String view="select Ended from `auctioned product` where AuctionID ="+AuctionID+";";
	        ResultSet rs=stmt.executeQuery(view);
	       
	        	  rs.next();
			      
	        		result=rs.getString(1);     
	        con.close();
	    } catch(Exception e)
	    {
	        System.out.println(e);
	    }
	    return result; 
	}
	
	public void updateStatus(int AuctionID)
	{
		String pattern = "MM-dd-yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime(); 
		String todayAsString = df.format(today);
		String result="";
	
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con =
	        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
	        Statement stmt=con.createStatement();
	    	if(getenddate(AuctionID).equalsIgnoreCase(todayAsString)) {
	    		  String view="update `auctioned product` set Status = "+"Unavailable"+" where UserId ="+AuctionID+";";
	  	        int rs=stmt.executeUpdate(view);
	  	      if(rs > 0) {
					System.out.println("Successful");
				}
				else {
					System.out.println("Not Succesful");
				}
	    	} 
	        
	      
	        con.close();
	    } catch(Exception e)
	    {
	        System.out.println(e);
	    }
	  
	}
		public void bidInsert(int Auctionid, int bidamount, int loginuserid)

	{
		
		try {
			Bidding bid = new Bidding();
			if(bid.balance(loginuserid)<bid.minbidAmount(Auctionid))
			{
				System.out.println("InSufficient Balance");
				bid.updatebalance(loginuserid, 7000);
			}
			
			else 
			{
				System.out.println("Sufficient Balance");
			
				if(bidamount<=bid.minbidAmount(Auctionid)||getpreviousbid(Auctionid)>=bidamount)
				{
					System.out.println("LESS amount enterted");
//					
				}
				
				else
				{
					
					if(emptyrecAuc(Integer.toString(Auctionid)).isEmpty()) {
						bid.bid(Auctionid, bidamount, loginuserid);
						bid.updateStatus(Auctionid);
						int newbalance=balance(loginuserid)-bidamount;
						bid.updatebalance(loginuserid, newbalance);
					}
					else 
					{ 
						bid.bid(Auctionid, bidamount, loginuserid);
						bid.updateStatus(Auctionid);
						int newbalance=balance(loginuserid)-bidamount;
						bid.updatebalance(loginuserid, newbalance);
				}
				
				}
					
				}
		}
		catch (Exception ex1) {
			ex1.printStackTrace();
		}
		
	
	}

	private void bid(int Auctionid, int bidamount, int loginuserid ) {

	 try{
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con =
	        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
	        Statement stmt=con.createStatement();
	        if(emptyrecAuc(Integer.toString(Auctionid))==""){
	        String fetchbalance="insert into `user buy auction` (`UserID`, `AuctionID`, `BidAmount`) values ('" + loginuserid+  "', '" +Auctionid+ "', '" +bidamount+ "');";
	        int rs=stmt.executeUpdate(fetchbalance);

	        if(rs > 0) {
				System.out.println("Bid placed");
			}
			else {
				System.out.println("Failed to Placed a Bid");
			}
	        }
	        else 
	        {
	        	 String fetchbalance="update `user buy auction` set `BidAmount`="+bidamount+",`UserID`="+loginuserid+" where AuctionID="+Auctionid+";"; 	        
	        	 int rs=stmt.executeUpdate(fetchbalance);

	 	        if(rs > 0) {
	 				System.out.println("Bid placed");
	 			}
	 			else {
	 				System.out.println("Failed to Placed a Bid");
	 			}
	        }
	        con.close();
	    } catch(Exception e)
	    {
	        System.out.println(e);
	    }
	
}
	
	private String emptyrecAuc(String Auctionid)
	{
		
		String minbid = "";
		 try{
		        Class.forName("com.mysql.jdbc.Driver");
		        Connection con =
		        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
		        Statement stmt=con.createStatement();
		        String fetchminimum ="select * from `user buy auction` where AuctionID="+Auctionid+";";
		        ResultSet rs=stmt.executeQuery(fetchminimum);
	
		        while(rs.next())
		        {
		       minbid += 
		                "Title: " + rs.getString(1) +
		                "\nDescription: " + rs.getString(2) +
		                "\nLocation: " + rs.getString(3);
		        }
		     
		
		      
				 
		        
		        con.close();
		    } catch(Exception e)
		    {
		        System.out.println(e);
		        e.printStackTrace();
		    }
		
		return minbid;
		
		
		
	}
	private void updatebalance(int userid1,int balancechange) 

{
	 try{
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con =
	        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
	        Statement stmt=con.createStatement();
	        String fetchbalance="update user set Balance = "+balancechange+" where UserId ="+userid1+";";
	        int rs=stmt.executeUpdate(fetchbalance);

	        if(rs > 0) {
				System.out.println("Balance Updated");
			}
			else {
				System.out.println("Failed Updation");
			}
	        

	        con.close();
	    } catch(Exception e)
	    {
	        System.out.println(e);
	        e.printStackTrace();
	    }

		}
		
	
	   
	private int balance(int userid) 
	{
		 int Balance = 0;
		 try{
		        Class.forName("com.mysql.jdbc.Driver");
		        Connection con =
		        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
		        Statement stmt=con.createStatement();
		        String fetchbalance="select Balance from user where UserId ="+userid+";";
		        ResultSet rs=stmt.executeQuery(fetchbalance);
		 

		        rs.next();
		      
		        		Balance=rs.getInt(1);     
		        		System.out.println(Balance);
		        con.close();
		    } catch(Exception e)
		    {
		        System.out.println(e);
		        e.printStackTrace();
		    }
		 
		 	return Balance;
		 	
		
	};
	
	private int getpreviousbid(int AuctionID) 
	{
		 int Previousbid = 0;
		 try{
		        Class.forName("com.mysql.jdbc.Driver");
		        Connection con =
		        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
		        Statement stmt=con.createStatement();
		        String fetchbalance="select BidAmount from `user buy auction` where AuctionID ="+AuctionID+";";
		        ResultSet rs=stmt.executeQuery(fetchbalance);
		 

		        rs.next();
		      
		        		Previousbid=rs.getInt(1);     
		        con.close();
		    } catch(Exception e)
		    {
		        System.out.println(e);
		        e.printStackTrace();
		    }
		 
		 	return  Previousbid;
		 	
		
	};
	
	private int minbidAmount(int auctionid) {
		
		 int minbid = 0;
		 try{
		        Class.forName("com.mysql.jdbc.Driver");
		        Connection con =
		        DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionsite","root","");
		        Statement stmt=con.createStatement();
		        String fetchminimum ="select minBidPrice from `auctioned product` where AuctionID="+auctionid+";";
		        ResultSet rs=stmt.executeQuery(fetchminimum);
	

		        while(rs.next())
		        {
		        	minbid=rs.getInt(1);
		              
		        }

		        con.close();
		    } catch(Exception e)
		    {
		        System.out.println(e + "gj");
		        e.printStackTrace();
		    }
		 
	        return minbid;		 
	};
	
	public static void main(String[] args) {
			//Bidding v = new Bidding();
			//bid.bidCheck(8, 6060, 3);
			//bid.updateStatus(1);
			//v.getProduct(8);
	}

}
