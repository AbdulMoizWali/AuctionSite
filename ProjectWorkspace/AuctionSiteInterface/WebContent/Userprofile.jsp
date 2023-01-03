
<%@ page import="main.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction Site</title>
</head>
<body>
<h1>User Profile</h1>
<%
User u1= new UserProxy().getUser();
String username, password;
username=request.getParameter("username");
password=request.getParameter("password");
out.println(u1.getloginID(username, password));
%>
</body>
</html>