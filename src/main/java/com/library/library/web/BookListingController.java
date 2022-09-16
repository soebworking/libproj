package com.library.library.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.library.service.BookRegistrationService;
import com.library.library.web.dto.BookRegistrationDto;


@Controller
@RequestMapping("/books/registration")
public class BookListingController {
	
	
	private BookRegistrationService bookRegistrationService;
	
	public BookListingController(BookRegistrationService bookRegistrationService) {
		super();
		this.bookRegistrationService = bookRegistrationService;
	}
	
	@GetMapping
	public String showBookRegistration() {
		return "bookRegistration";
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
	
	
	

}
