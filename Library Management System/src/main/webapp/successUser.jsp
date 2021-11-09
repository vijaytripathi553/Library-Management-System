<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.spokentutorial.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success Page</title>
</head>
<body bgcolor='white'>
<!-- Page Heading -->

<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align="center" valign="center" height='20'>
<td><h3>Library Management System: Add User Success</h3></td>
</tr>
</table>


<% User user=(User)request.getAttribute("user");
%>
<div>
Your request to add<b> <font color=green size=4><i><%=user.getUsername() %></b></font> was successful</i>
</div>
<center>Click <a href="index.jsp">here</a></center>
</body>
</html>