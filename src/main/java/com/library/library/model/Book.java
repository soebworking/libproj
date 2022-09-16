package com.library.library.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "book", uniqueConstraints = @UniqueConstraint(columnNames = "book_name"))
public class Book {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "num_of_copy")
	private int bookNumCopy;
	
	
	
	public Book() {
		
	}
	
	



	public Book(String bookName, int bookNumCopy) {
		this.bookName = bookName;
		this.bookNumCopy = bookNumCopy;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookNumCopy() {
		return bookNumCopy;
	}

	public void setBookNumCopy(int bookNumCopy) {
		this.bookNumCopy = bookNumCopy;
	}
	

	
	
}
