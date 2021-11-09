<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Index Page</title>
</head>
<body style="background-color:snow";>
<div>
<font color="white"><h2 align="center" style="background-color:gray"><b>Library Management System</b></h2></font>
</div>

<p><a href="visitorHomePage.jsp">Visitors Home Page</a></p>

<%
if(request.getAttribute("errorMsgs")!= null){

%>

<div>
<%= "Please correct the following errors!!.." %>
</div>

<%
java.util.List<String> errorMsgs=(java.util.List)request.getAttribute("errorMsgs");
for(String errorMsg:errorMsgs){
%>
<li><%=errorMsg %></li>
<%
}
}
%>


<center>
<p><font color="red" size=4><b>Login Form</b></font></p>
<table>
<form method="POST" action="GreetingServlet">
<tr>
<td>Username:</td><td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password:</td><td><input type="password" name="password"></td>
</tr>

<tr>
<td><input type="submit"  value="submit"></td>
<br>
<td><p><b>New user<a href="addUser.jsp">Register Here....!!!</a></p></b></td>
</tr>
</table>

</form>

</center>
</body>
</html>