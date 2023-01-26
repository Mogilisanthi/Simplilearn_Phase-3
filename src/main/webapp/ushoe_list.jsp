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
<%
List<Shoe> pp=(List<Shoe>)request.getAttribute("r_list");%>
<table border="1">
<tr><th>Shoe_Id</th><th>Shoe_Name</th><th>Shoe_Code</th><th>Shoe_Brand</th><th>Shoe_Price</th><th>Buy Shoe</th></tr>
<%for(Shoe ps:pp){%>
<tr><td><%=ps.getShoe_id()%></td><td><%=ps.getShoe_name()%></td><td><%=ps.getShoe_code()%></td><td><%=ps.getShoe_brand()%></td><td><%=ps.getShoe_price()%></td>
<td>
<form action="./buy_shoe">
<input type="hidden" name="bank_id" value=<%=ps.getShoe_id() %>>
<input type="submit" class="button" value="buy">
</form>
</td>

</tr>
<%}%>
</table>
<a href="user_logout.jsp">User logout</a><br><br>
</body>
</html>