package com.spokentutorial.model;

import java.util.Date;

public class CheckOut {
	
	private int transactionId;
	private int bookId;
	private String username;
	private Date returnDate;
	
	
	
	// Default Constructor
	public CheckOut()
	{
		
		
	}
	
	
	// Parameterized Constructor
	public CheckOut(int transactionId, int bookId, String username, Date returnDate) {
		super();
		this.transactionId = transactionId;
		this.bookId = bookId;
		this.username = username;
		this.returnDate = returnDate;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	
	
	
	
	
}
