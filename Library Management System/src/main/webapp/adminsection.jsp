<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Section Page</title>
</head>
<body>
<form action="AdminSection" method="post">
<table border="1" cellpadding="5" cellspacing="0" width='400'>
<tr bgcolor='#CCCCFF' align="center" valign="center" height="20">
<td><h3>Welcome to Admin Section Page</h3></td>
</tr>
</table>


<p>
This is the page for  Admin Section.
</p>

<input type="radio" name="menuselection" value="listbooks">List Books<br>

<input type="radio" name="menuselection" value="listborrowedbooks">List Borrowed Books<br><br>

<input type="radio" name="menuselection" value="listusers">List Users<br><br>

<input type="radio" name="menuselection" value="checkoutbook">Checkout/Return Book<br><br>

<font color='green'><input type="Submit" value="submit"></font>
<br><br>	

<center>
Click <a href="index.jsp">here</a> to log out.
</center>
</form>
</body>
</html>