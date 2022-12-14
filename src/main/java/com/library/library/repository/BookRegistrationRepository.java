package com.library.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.library.model.Book;


@Repository
public interface BookRegistrationRepository extends JpaRepository<Book, Long> {
	
	Book findByid(Long id);
	
}
