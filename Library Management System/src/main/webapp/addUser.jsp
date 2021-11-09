<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.spokentutorial.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Page</title>
</head>
<body>

<table>
<tr>
<td>This form allow you to add a new 	user</td>
</tr>
</table>

<%
User user=new User();
if(request.getAttribute("errorMsgs")!= null){

%>

<div>
<font color=red size=4> <%= "Please correct the following errors!!.." %></font>
</div>

<%
java.util.List<String> errorMsgs=(java.util.List)request.getAttribute("errorMsgs");
for(String errorMsg:errorMsgs){
%>
<li><%=errorMsg %></li>
<%}

user=(User)request.getAttribute("user");
}
%>





<p><font color="red">Registration Form</font></p>
<table>
<form method="POST" action="AddUserServlet">
<tr>
<td>FirstName:</td><td><input type="text" name="firstName" %></td>
</tr>
<tr>
<td>LastName:</td><td><input type="text" name="lastName"></td>
</tr>
<tr>
<td>Email:</td><td><input type="text" name="email"></td>
</tr>
<tr>
<td>Username:</td><td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password:</td><td><input type="password" name="password"></td>
</tr>



<tr>
<td><input type="submit"  value="submit"></td>
</tr>
</table>

</form>
</body>
</html>