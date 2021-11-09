package com.spokentutorial.lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spokentutorial.model.CheckOut;

public class GreetingServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		out.println("<h2>Hello from POST method</h2> "+username);
		
		
		// Logic to redirect to the Admin Page
		if(username.equals("admin") && password.equals("admin"))
		{
			RequestDispatcher view=request.getRequestDispatcher("adminsection.jsp");
			view.forward(request, response);
			return;
		}
		else
		{
			
		
		
		
		
		// Send the error page view
		List<String> errorMsgs=new ArrayList();
		request.setAttribute("errorMsgs",errorMsgs);
		
		//JDBC Connectivity
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","1234");
					java.sql.PreparedStatement stmt=con.prepareStatement("Select * from user where username= ? and password= ?");
					stmt.setString(1, username);
					stmt.setString(2, password);
					ResultSet rs=stmt.executeQuery();
					
					String id=null;
					if(rs.next())
					{
						id=rs.getString(1);
					}
					else
					{
						errorMsgs.add("Invalid Username or Password");
					}
					
					//Send the ErrorPage view if there is error in a form
					if(!errorMsgs.isEmpty())
					{
						RequestDispatcher view=request.getRequestDispatcher("index.jsp");
						view.forward(request, response);
						return;
					}
					// Send the success view
					
					
					
					stmt=con.prepareStatement("SELECT * from checkout where username= ? order by return_date");		
					stmt.setString(1, username);
					rs=stmt.executeQuery();
					List<CheckOut> checkedOutItems=new ArrayList<CheckOut>();
					while(rs.next())
					{	
						CheckOut item=new CheckOut();
						item.setTransactionId(rs.getInt(1));
						item.setBookId(rs.getInt(2));
						item.setUsername(rs.getString(3));
						item.setReturnDate(rs.getDate(4));
						checkedOutItems.add(item);
					}
					request.setAttribute("checkedOutItems", checkedOutItems);
					
					
					
					
					RequestDispatcher view=request.getRequestDispatcher("successGreeting.jsp");
					view.forward(request, response);
					return;
				}
				catch(SQLException | ClassNotFoundException e) 
				{
					System.out.println(e);
				}
				
				
		} // else closing
				
		
		
		
		
	}

	
	
}
