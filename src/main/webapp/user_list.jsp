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
<% List<User> u = (List<User>)request.getAttribute("u_list"); %>
<table border="1">
<tr><th>User_Id</th><th>User_Fname</th><th>User_Lname</th><th>User_Phonenumber</th><th>User_MailId</th><th>User_DOB</th><th>User_Password</th></tr>

<%for(User us:u){%>
<tr><td><%=us.getUser_id()%></td><td><%=us.getUser_fname()%></td><td><%=us.getUser_lname()%></td><td><%=us.getUser_phone()%></td><td><%=us.getUser_mail()%></td><td><%=us.getUser_dob()%></td><td><%=us.getUser_pass()%></td></tr>
<%}%>
</table>
</body>
</html>