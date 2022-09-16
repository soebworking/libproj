package com.library.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.library.model.UsersBooks;
import com.library.library.web.dto.BookUsersBooksDto;




@Repository
public interface UsersBooksRepository extends JpaRepository<UsersBooks, Long> {
	Long findUserById(Long userId);
	Long countByuserId(Long userId);
	
	@Query(value = "select  b.id as bookId, b.book_name as bookName, b.num_of_copy as numOfCopyOfBook, "
			+ "ub.id as uBId, ub.book_id as usersBooksId, ub.user_id as userId from book b "
			+ "left join users_books ub on b.id = ub.book_id"
			, nativeQuery = true )
	List<BookUsersBooksDto> fetchBookUsersBookData();

}
