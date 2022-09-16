package com.library.library.web.dto;

public interface BookUsersBooksDto {
	
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections

	Long getBookId();
	String getBookName();
	Long getNumOfCopyOfBook();
	Long getUBId();
	Long getUsersBooksId();
	Long getUserId();
	

	
	
}
