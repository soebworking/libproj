package com.library.library;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.library.model.Book;
import com.library.library.service.BookRegistrationService;



@SpringBootTest
public class BookRegistrationServiceTest {

	 /**
     * Autowire in the service we want to test
     */
    @Autowired
	BookRegistrationService bookRegService;
	
	
	@Test
	public void findAllTest() {
		
		// Execute the service call
        List<Book> book = bookRegService.findAll();
        assertThat(book).isNotNull();
		
		
	}
	
	
}
