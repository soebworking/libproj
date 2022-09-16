package com.library.library.service;

import java.util.List;

import com.library.library.model.Book;
import com.library.library.web.dto.BookRegistrationDto;



public interface BookRegistrationService {

	List<Book> findAll();
	
	Book save(BookRegistrationDto bookRegistrationDto);
	
	Boolean updateBookNumOfCopy(Long id);
	Boolean updateBookNumOfCopyByOne(Long id);
	
	Long checkBookCount();
	
}
