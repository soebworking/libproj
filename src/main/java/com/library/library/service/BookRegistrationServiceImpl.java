package com.library.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.library.model.Book;
import com.library.library.repository.BookRegistrationRepository;
import com.library.library.web.dto.BookRegistrationDto;




@Service
public class BookRegistrationServiceImpl implements BookRegistrationService {

	private BookRegistrationRepository bookRegistrationRepository;
	
		
	public BookRegistrationServiceImpl(BookRegistrationRepository bookRegistrationRepository) {
		//super();
		this.bookRegistrationRepository = bookRegistrationRepository;
		
	}
	
	@Override
	public Book save(BookRegistrationDto bookRegistrationDto) {

		Book book = new Book(bookRegistrationDto.getBookName(), bookRegistrationDto.getBookNumCopy());
		return bookRegistrationRepository.save(book);
		
	}


	@Override
	public List<Book> findAll() {
		return bookRegistrationRepository.findAll();
	}

	@Override
	public Boolean updateBookNumOfCopy(Long id) {
		Book book = bookRegistrationRepository.findByid(id);
		book.setBookNumCopy(book.getBookNumCopy() - 1 );
		book.setBookName(book.getBookName());
		book.setId(id);
		bookRegistrationRepository.save(book);
		return true;
	}

	@Override
	public Boolean updateBookNumOfCopyByOne(Long id) {
		Book book = bookRegistrationRepository.findByid(id);
		book.setBookNumCopy(book.getBookNumCopy() + 1 );
		book.setBookName(book.getBookName());
		book.setId(id);
		bookRegistrationRepository.save(book);
		return true;
	}

	@Override
	public Long checkBookCount() {
		return bookRegistrationRepository.count();
	}
	
	
	

}
