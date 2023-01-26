<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ecommerce.example.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Admin> pass = (List<Admin>)request.getAttribute("pass_list"); %>

<table border="1">
<tr><th>Password</th></tr>
<% for(Admin aa : pass ) { %> 
<tr><td><%= aa.getAd_pass()%></td></tr>
<%} %>
</table>
</body>
</html>