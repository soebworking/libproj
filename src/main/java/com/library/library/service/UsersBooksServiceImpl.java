package com.library.library.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.library.library.model.Book;
import com.library.library.model.User;
import com.library.library.model.UsersBooks;
import com.library.library.repository.UserRepository;
import com.library.library.repository.UsersBooksRepository;
import com.library.library.web.dto.BookUsersBooksDto;
import com.library.library.web.dto.UsersBooksDto;




@Service
public class UsersBooksServiceImpl implements UsersBooksService {

	private UsersBooksRepository usersBooksRepository;
	private UserRepository userRepository;
	
	public UsersBooksServiceImpl(UsersBooksRepository usersBooksRepository, UserRepository userRepository) {
		this.userRepository = userRepository;
		this.usersBooksRepository = usersBooksRepository;
	}
	
	public Long getUserId(String userName) {
		User user = userRepository.findByEmail(userName);
		return user.getId();
	}

	@Override
	public UsersBooks save(UsersBooksDto userBooksDto) {
		
		UsersBooks usersBooks = new UsersBooks(userBooksDto.getUserId(),userBooksDto.getBookId());
		return usersBooksRepository.save(usersBooks);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Long getIssedBooks(Long userId) {

		return  usersBooksRepository.countByuserId(userId);
		
	}
	
	public List<BookUsersBooksDto> getBooksUsersBooksData(){
		
		return usersBooksRepository.fetchBookUsersBookData();
		
	}

	@Override
	public Boolean deleteOnReturn(Long id) {
		// TODO Auto-generated method stub
		usersBooksRepository.deleteById(id);
		return true;
	}
	
	

	
	
	

}
