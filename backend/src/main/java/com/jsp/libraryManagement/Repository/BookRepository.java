package com.jsp.libraryManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.libraryManagement.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByGenre(String genre);
	}
