package com.spokentutorial.lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spokentutorial.model.User;

public class AddUserServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		List<String> errorMsgs=new ArrayList<String>();
		//JDBC variable
		PrintWriter out=response.getWriter();
		
		// Send the error page view
		request.setAttribute("errorMsgs",errorMsgs);
		
		try
		{
			//Retrive form parameter
			String id=null;
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String email=request.getParameter("email");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			// Verify form parameter
			if(firstName.length()==0)
			{
				errorMsgs.add("Please Enter the FirstName");
			}
			
			if(lastName.length()==0)
			{
				errorMsgs.add("Please Enter the LastName");
			}
			
			if(email.length()==0)
			{
				errorMsgs.add("Please Enter the Email");
			}
			
			if(username.length()==0)
			{
				errorMsgs.add("Please Enter the Username");
			}
			if(password.length()==0)
			{
				errorMsgs.add("Please Enter the Password");
			}
			
			
			//Perform Business Logic
			User user=new User(firstName,lastName,email,username,password);
			// Store the new user in thr request scope
			request.setAttribute("user",user);
			// Send the errorpage view if there were errors
			if(!errorMsgs.isEmpty())
			{
				RequestDispatcher view=request.getRequestDispatcher("addUser.jsp");
				view.forward(request,response);
				return;
			}
			
			// Store the new user into the database
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");
				//statement =con.createStatement();
				PreparedStatement 	pstmt=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
				pstmt.setString(1, id);
				pstmt.setString(2, firstName);
				pstmt.setString(3, lastName);
				pstmt.setString(4, email);
				pstmt.setString(5, username);
				pstmt.setString(6, password);
				pstmt.executeUpdate();
				// Send the success view
				System.out.println("Record Inserted Successfully.......");
				RequestDispatcher view=request.getRequestDispatcher("successUser.jsp");
				view.forward(request,response);
				return;
			
				
			}
			catch(SQLException e)
			{
				errorMsgs.add(e.getMessage());
				//dispatch to the errorpage
				RequestDispatcher view=request.getRequestDispatcher("addUser.jsp");
				e.printStackTrace();
				view.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		// Handle any unexpecte decision
		catch(RuntimeException e)
		{
			errorMsgs.add(e.getMessage());
			// dispatch to the error page
			RequestDispatcher view=request.getRequestDispatcher("successGreeting.jsp");
			view.forward(request, response);
			
	}  // End of try-catch block
	} // End of doGet
} //End of class
