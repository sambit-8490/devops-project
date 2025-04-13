package com.jsp.libraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.libraryManagement.DAO.AuthorDao;
import com.jsp.libraryManagement.DAO.BookDao;
import com.jsp.libraryManagement.DTO.ResponseStructure;
import com.jsp.libraryManagement.Entity.Author;
import com.jsp.libraryManagement.Entity.Book;
import com.jsp.libraryManagement.Exception.IdNotFoundException;

@Service
public class BookService {
	@Autowired
	BookDao bookDao;
	@Autowired
	AuthorDao authorDao;
	//save book
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book){
		Optional<Author> author=authorDao.getAuthorById(book.getAuthor().getId());
		if(author.isPresent()) {
			Book recievedBook=bookDao.saveBook(book);
			book.setAuthor(author.get());
			ResponseStructure<Book> structure = new ResponseStructure<Book>();
			structure.setStatusCode(HttpStatus.CREATED.value()); //201
			structure.setMessage("success");
			structure.setData(recievedBook);
			return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new IdNotFoundException();
		}
	}


	//get all books
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks(){
		List<Book> recievedBook = bookDao.getAllBooks();
		ResponseStructure<List<Book>> structure = new ResponseStructure<List<Book>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedBook);
		return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
	}

	//get book by id
	public ResponseEntity<ResponseStructure<Book>> getBookById(int id){
		Optional<Book> opt= bookDao.getBookById(id);
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

	//update book
	public ResponseEntity<ResponseStructure<Book>> updateBook(Book book){
		Book recievedBook = bookDao.updateBook(book);
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedBook);
		return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
	}

	//delete book
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int id){
		Optional<Book> opt= bookDao.getBookById(id);
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		if(opt.isPresent()) {
			Book book =opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(opt.get());
			bookDao.deleteBook(book);
			return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	//find book by genre
	public ResponseEntity<ResponseStructure<List<Book>>>findBooksByGenre(String genre) { 
		List<Book> recievedBook =bookDao.findBooksByGenre(genre);
		ResponseStructure<List<Book>> structure = new ResponseStructure<List<Book>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedBook);
		return new ResponseEntity<ResponseStructure<List<Book>>>(structure, HttpStatus.OK);
	}
}
