package com.library.library.web.dto;


public class UsersBooksDto {
	
	
	private Long userId;
	private Long bookId;
	
	
	
	public UsersBooksDto() {
		
	}
	

	public UsersBooksDto(Long userId, Long bookId) {
		super();
		this.userId = userId;
		this.bookId = bookId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getBookId() {
		return bookId;
	}


	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	

}
