<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.spokentutorial.model.CheckOut" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Library Management System: List Books Page</title>
</head>
<body bgcolor='white'>

<table border='1', cellpadding='5', cellspacing='0'	width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
<td><h3>Library Management System: List Borrowed Books</h3></td>

</tr>
</table>

<p>This form allows you to view the list of borrowed books.</p>

<%
List<CheckOut> checkOut=(ArrayList<CheckOut>) request.getAttribute("checkOutList");
List<CheckOut> past_returndate = (ArrayList<CheckOut>)request.getAttribute("past_returndate");
%>
<br><br>

List of book issued

<table width='100%' border='1'>
<thead align='center'>
<th>Transaction Id</th>
<th>Book Id</th>
<th>UserName</th>
</thead>


<%
for(CheckOut checkoutInstance:checkOut){
%>	
	<tr align='center'>
            <td><%=checkoutInstance.getTransactionId()%></td>	
            <td><%=checkoutInstance.getBookId()%></td>
            <td><%=checkoutInstance.getUsername()%></td>

	</tr>
<%
}
%>
</table>

<br><br>
List of books which are past their return date

<table width='100%' border='1'>
<thead align='center'>
<th>Transaction Id</th>
<th>Book Id</th>
<th>UserName</th>
</thead>
<%
for(CheckOut checkoutInstance:past_returndate){
%>	
	<tr align='center'>
            <td><%=checkoutInstance.getTransactionId()%></td>	
            <td><%=checkoutInstance.getBookId()%></td>
            <td><%=checkoutInstance.getUsername()%></td>

	</tr>
<%
}
%>


</table>

</body>
</html>