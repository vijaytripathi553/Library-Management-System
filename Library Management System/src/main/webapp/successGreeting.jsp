<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.spokentutorial.model.CheckOut" %>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Library Management System: Success Greeting Page</title>
</head>
<body bgcolor='white'>

<table border='1', cellpadding='5', cellspacing='0'	width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
<td><h3>Library Management System: Success Greeting Page</h3></td>

</tr>
</table>

<%
List<CheckOut> cout=(ArrayList<CheckOut>)request.getAttribute("checkedOutItems");
%>

<p>You have successfully logged in!!!!!.</p>

<u>Books currently borrowed by you:</u><br/><br/>	
<table width='100%' border='1'>
<thead align='center'>
<th>Transaction Id</th>
<th>User Name</th>
<th>Book Id</th>
<th>Return Date</th>
</thead>

<%
for (CheckOut co:cout){
%>


<tr align='center'>
		<td><%=co.getTransactionId()%></td>
		<td><%=co.getUsername()%></td>
		<td><%=co.getBookId()%></td>
        <td><%=co.getReturnDate()%></td>
	</tr>
<%
}
%>


</table>

</body>
</html>