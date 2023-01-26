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
<form action="Update_shoe">
<table>
<tr><td><input type="hidden" name="shoe_id" value=<%=request.getParameter("shoe_id") %>></td></tr>
<tr><td>Edit shoe name</td><td><input type="text" name="shoe_name"></td></tr>
<tr><td>Edit shoe code</td><td><input type="text" name="shoe_code"></td></tr>
<tr><td>Edit shoe brand</td><td><input type="text" name="shoe_brand"></td></tr>
<tr><td>Edit shoe price</td><td><input type="text" name="shoe_price"></td></tr>
<tr><td>Edit shoe selldate</td><td><input type="text" name="sell_date"></td></tr>
<tr><td><input type="submit" class= "button" value="update shoe details"></td></tr>
</table>
<a href="admin_logout.jsp">Admin logout</a><br><br>
</form><br>
</body>
</html>