package com.library.library.service;

import java.util.List;

import com.library.library.model.Book;
import com.library.library.model.UsersBooks;
import com.library.library.web.dto.BookUsersBooksDto;
import com.library.library.web.dto.UsersBooksDto;


public interface UsersBooksService {

	UsersBooks save(UsersBooksDto usersBooksDto);
	List<Book> findAll();
	Long getUserId(String userName);
	Long getIssedBooks(Long userId);
	List<BookUsersBooksDto> getBooksUsersBooksData();
	Boolean deleteOnReturn(Long id);
	
}
