package com.library.library.web;

import java.security.Principal;
import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.library.service.BookRegistrationService;
import com.library.library.service.UsersBooksService;
import com.library.library.web.dto.BookRegistrationDto;
import com.library.library.web.dto.UsersBooksDto;



@Controller
//@RequestMapping("/books/listing")
public class BookRegistrationController {
	
	
	private BookRegistrationService bookRegistrationService;
	private UsersBooksService usersBooksService;
	private UsersBooksDto usersBooksDto;
	
	
	public BookRegistrationController(BookRegistrationService bookRegistrationService, UsersBooksService usersBooksService
			) {
		super();
		this.bookRegistrationService = bookRegistrationService;
		this.usersBooksService = usersBooksService;
		
	}
	
	@GetMapping("/books/listing")
	public String showBookRegistration(Model model, Principal principal) {
		model.addAttribute("books", usersBooksService.getBooksUsersBooksData());
		Long userId = usersBooksService.getUserId(principal.getName());
		
		model.addAttribute("bookCount", usersBooksService.getIssedBooks(userId));
		model.addAttribute("numOfBook", bookRegistrationService.checkBookCount());
		return "bookListing";
	}
	
	
	@ModelAttribute("book")
	public BookRegistrationDto bookRegistrationDto() {
		return new BookRegistrationDto();
	}
	
	@PostMapping
	public String registerBook(@ModelAttribute("book") BookRegistrationDto bookRegistrationDto) {
		bookRegistrationService.save(bookRegistrationDto);
		return "redirect:/books/registration?success";
	}
	
	@GetMapping("/books/add/{id}")
	public String addBookToCart(@PathVariable Long id, Principal principal) {

		Long userId = usersBooksService.getUserId(principal.getName());
		usersBooksDto = new UsersBooksDto(userId, id);
		usersBooksService.save(usersBooksDto);
		//reduce num_of_copy
		bookRegistrationService.updateBookNumOfCopy(id);
		
		
		return "redirect:/books/listing?success";
		
	}
	
	
	@GetMapping("/books/return/{id}/book/{bookId}")
	public String addBookToLibrary(@PathVariable Long id, @PathVariable Long bookId) {
	
		// delete entry from users_books
		usersBooksService.deleteOnReturn(id);
		
		//reduce num_of_copy
		bookRegistrationService.updateBookNumOfCopyByOne(bookId);
		
		
		return "redirect:/books/listing?success";
		
	}
	
	
	
//	public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false)){
//		List<Book> books = new ArrayList<Book>(); 
//		books = bookRegistrationService.findAll().forEach(books::add);
//		if(books.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(books, HttpStatus.OK);
//		
//	}

}
