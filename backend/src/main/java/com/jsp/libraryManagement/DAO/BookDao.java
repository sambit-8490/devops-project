package com.jsp.libraryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.libraryManagement.Entity.Book;
import com.jsp.libraryManagement.Repository.BookRepository;

@Repository
public class BookDao {
	@Autowired
	private BookRepository bookRepository;

	//save book
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	//get all books
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}

	//get book by id
	public Optional<Book> getBookById(int id) {
		return bookRepository.findById(id);
	}

	//update book
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	//delete book
	public void deleteBook(Book book){
		bookRepository.delete(book);;
	}
	//find book by genre
	public List<Book> findBooksByGenre(String genre) { 
		return bookRepository.findByGenre(genre); }
}