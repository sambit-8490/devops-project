package com.jsp.libraryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.libraryManagement.Entity.Author;
import com.jsp.libraryManagement.Repository.AuthorRepository;

@Repository
public class AuthorDao {
	@Autowired
	private AuthorRepository authorRepository;

	//save author
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	//get all authors
	public List<Author> getAllAuthors(){
		return authorRepository.findAll();
	}

	//get author by id
	public Optional<Author> getAuthorById(int id) {
		return authorRepository.findById(id);
	}

	//update author
	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}

	//delete author
	public void deleteAuthor(Author author){
		authorRepository.delete(author);;
	}
}