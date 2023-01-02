<%@ page import="main.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start Auction</title>        
	<link rel="stylesheet" href="jquery.datetimepicker.min.css" />
</head>
<body>
	<script src="jquery.js"></script>
	<script src="jquery.datetimepicker.full.min.js"></script>
	
	<h1>Insert Auction</h1>
	
	
	
	<form>
		<label>Product Name</label>
		<input name="ProductName" type="text"></input>
		<br>
		<br>
		<label>Product Description</label>
		<input name="ProductDescription" type="text"></input>
		<br>
		<br>
		<label>Product Category</label>
		<select name = "Category">
			<option value = "Clothing, Shoes & Accessories">Clothing, Shoes & Accessories</option>
			<option value = "Sporting Goods">Sporting Goods</option>
			<option value = "Home & Garden">Home & Garden</option>
			<option value = "Toys & Hobbies">Toys & Hobbies</option>
			<option value = "Business & Industrial">Business & Industrial</option>
			<option value = "Health & Beauty">Health & Beauty</option>
			<option value = "Pet Supplies">Pet Supplies</option>
			<option value = "Baby Essentials">Baby Essentials</option>
			<option value = "Electronics">Electronics</option>
			<option value = "Collectibles & Art">Collectibles & Art</option>
			<option value = "Books">Books</option>
		</select>
		<br>
		<br>
		<label>Pickup Location</label>
		<input name="Location" type="text"></input>
		<br>
		<br>
		<label>Auction Start Date Time</label>
	    <input type="text" name="AuctionStartDate" id="AuctionStartDate">       
		<script>
			$('#AuctionStartDate').datetimepicker();
		</script>
		<br>
		<br>
		<label>Minimum Biding Amount</label>
		<input name="MinBidPrice" type="text"></input>
		<br>
		<br>
	    <button type="submit">Add Auction</button>
	    <%
		String ProductName = request.getParameter("ProductName");
		String ProductDescription = request.getParameter("ProductDescription");
		String Category = request.getParameter("Category"); 
		String Location = request.getParameter("Location"); 
		String AuctionStartDate = request.getParameter("AuctionStartDate");
		String MinBidPrice = request.getParameter("MinBidPrice");
		Auction auction = new AuctionProxy().getAuction();
		AuctionRequest payload = new AuctionRequest();
		out.println(ProductName);
		if(ProductName != "" || ProductName != null){
			auction.insertAuctionWithProduct( "1",
					 ProductName, 
					 ProductDescription, 
					 Category, 
					 Location,
					 AuctionStartDate, 
					 MinBidPrice
				);
		} 
		%>	
	</form>

	
</body>
</html>













