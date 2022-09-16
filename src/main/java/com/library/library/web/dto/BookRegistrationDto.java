package com.library.library.web.dto;


public class BookRegistrationDto {
	
	
	private String bookName;
	private int bookNumCopy;
	
	
	
	public BookRegistrationDto() {
		
	}
	

	public BookRegistrationDto(String bookString, int bookNumCopy) {
		super();
		this.bookName = bookString;
		this.bookNumCopy = bookNumCopy;
	}
	
	
	
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookNumCopy() {
		return bookNumCopy;
	}
	public void setBookNumCopy(int bookNumCopy) {
		this.bookNumCopy = bookNumCopy;
	}
	
	
	

}
