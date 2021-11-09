package com.spokentutorial.lms;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spokentutorial.model.Book;
import com.spokentutorial.model.CheckOut;


public class AdminSection extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String menuselection=request.getParameter("menuselection");
		
		if(menuselection.equals("listbooks"))
		{
			try
			{
				//1. Loading the Driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//2. Creating a Connection
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","1234");
				
				//3. Create Statement
				Statement stmt=con.createStatement();
				
				//4.
				ResultSet rs=stmt.executeQuery("SELECT * FROM books");
				
				List<Book> bookList=new ArrayList();
				
				//Iterate every book from the ResultSet object
				while(rs.next())
				{
					Book book=new Book();
					
					book.setBookId(rs.getInt("id"));
					book.setBookName(rs.getString("bookName"));
					book.setAuthorName(rs.getString("authorName"));
					book.setISBN(rs.getString("ISBN"));	
					book.setPublisher(rs.getString("publisher"));
					book.setTotalCopies(rs.getInt("totalcopies"));
					book.setAvailableCopies(rs.getInt("availablecopies"));
					
					// Adding book object into list
					bookList.add(book);
				}
				// Then we set ArrayList books into the request
				request.setAttribute("bookList",bookList);
				
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("listBook.jsp");
				requestDispatcher.forward(request, response);
				
				
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		 // If Selecting the second radio button
		else if(menuselection.equals("listborrowedbooks"))
		{
			
			
			try
			{
				//1. Loading the Driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//2. Creating a Connection
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","1234");
				
				//3. Create Statement
				Statement stmt=con.createStatement();
				
				//4.
				ResultSet rs=stmt.executeQuery("SELECT * FROM checkout order by transaction_Id");
				
				List<CheckOut> checkOutList=new ArrayList();
				
				//Iterate every book from the ResultSet object
				while(rs.next())
				{
					CheckOut co=new CheckOut();
					
					co.setBookId(rs.getInt("book_Id"));
					co.setTransactionId(rs.getInt("transaction_Id"));
					co.setUsername(rs.getString("username"));
					
					// Adding book object into list
					checkOutList.add(co);
				}
				// Then we set ArrayList books into the request
				request.setAttribute("checkOutList",checkOutList);
				
				
				
				
				
				
				ResultSet rs1=stmt.executeQuery("SELECT * FROM checkout where return_Date < now() order by transaction_Id ");
				List<CheckOut> past_returndate = new ArrayList<CheckOut>();
				while(rs1.next())
				{
					CheckOut co=new CheckOut();
					co.setBookId(rs1.getInt("book_Id"));
					co.setTransactionId(rs1.getInt("transaction_Id"));
					co.setUsername(rs1.getString("username"));
						
					// Adding book object into list
					past_returndate.add(co);	
					
				}
				// Then we set ArrayList books into the request
				request.setAttribute("past_returndate",past_returndate);
				
				
				
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("listBorrowedBook.jsp");
				requestDispatcher.forward(request, response);
			}
			catch(SQLException e)
			{
				System.out.println(e);
				
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			
				
		} // else if closing
		
		else if(menuselection.equals("checkoutbook"))
		{
			
			try
			{
				//1. Loading the Driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//2. Creating a Connection
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","root","1234");
				
				//3. Create Statement
				Statement stmt=con.createStatement();
				
				//4.
				ResultSet rs=stmt.executeQuery("SELECT * FROM books");
				
				List<Book> bookList=new ArrayList();
				
				//Iterate every book from the ResultSet object
				while(rs.next())
				{
					Book book=new Book();
					
					book.setBookId(rs.getInt("id"));
					book.setBookName(rs.getString("bookName"));
					book.setAuthorName(rs.getString("authorName"));
					book.setISBN(rs.getString("ISBN"));	
					book.setPublisher(rs.getString("publisher"));
					book.setTotalCopies(rs.getInt("totalcopies"));
					book.setAvailableCopies(rs.getInt("availablecopies"));
					
					// Adding book object into list
					bookList.add(book);
				}
				// Then we set ArrayList books into the request
				request.setAttribute("bookList",bookList);
				
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("checkOut.jsp");
				requestDispatcher.forward(request, response);
				
				
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			
			
		}  // else if closing
		
		
		
		
		
	}

}
	