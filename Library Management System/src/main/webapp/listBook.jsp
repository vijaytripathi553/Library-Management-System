<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.*" %>
     <%@page import="com.spokentutorial.model.Book" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Library Management System: List Books Page</title>
</head>
<body bgcolor='white'>

<table border='1', cellpadding='5', cellspacing='0'	width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
<td><h3>Library Management System: List Books</h3></td>

</tr>
</table>

<p>This form allows you to view the list of books.</p>

<%
List<Book> books=(ArrayList<Book>)request.getAttribute("bookList");
%>



<table width='100%' border='1'>
<thead align='center'>
<th>Book Id</th>
<th>Book Name</th>
<th>Author Name</th>
<th>ISBN</th>
<th>Publisher</th>
<th>Total Copies</th>
<th>Available Copies</th>
</thead>


<%
for (Book book:books){
%>
<tr align='center'>
//<td><%=book.getBookId() %></td>
<td><%=book.getBookName() %></td>
<td><%=book.getAuthorName() %></td>
<td><%=book.getISBN() %></td>
<td><%=book.getPublisher() %></td>
<td><%=book.getTotalCopies()%></td>
<td><%=book.getAvailableCopies()%></td>
</tr>


<% 
}
%>


</table>

</body>
</html>