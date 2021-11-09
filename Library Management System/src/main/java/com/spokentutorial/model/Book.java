package com.spokentutorial.model;

public class Book {
	
	private int bookId;
	private String bookName;
	private String authorName;
	private String ISBN;
	private String publisher;
	private int totalCopies;
	private int availableCopies;
	
	// Default Constructor
	public Book()
	{
		
	}
	

	// Parameterized Constructor
	public Book(int bookId, String bookName, String authorName, String iSBN, String publisher, int totalCopies,
			int availableCopies) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		ISBN = iSBN;
		this.publisher = publisher;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
		
		
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getTotalCopies() {
		return totalCopies;
	}


	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}


	public int getAvailableCopies() {
		return availableCopies;
	}


	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	
	
	
	

}
