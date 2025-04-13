package com.jsp.libraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.libraryManagement.DAO.AuthorDao;
import com.jsp.libraryManagement.DTO.ResponseStructure;
import com.jsp.libraryManagement.Entity.Author;
import com.jsp.libraryManagement.Exception.IdNotFoundException;

@Service
public class AuthorService {
	@Autowired
	AuthorDao authorDao;

	//save author
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author author){
		Author recievedAuthor=authorDao.saveAuthor(author);

		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("success");
		structure.setData(recievedAuthor);
		return new ResponseEntity<ResponseStructure<Author>>(structure, HttpStatus.CREATED);
	}


	//get all authors
	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthors(){
		List<Author> recievedAuthor = authorDao.getAllAuthors();
		ResponseStructure<List<Author>> structure = new ResponseStructure<List<Author>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedAuthor);
		return new ResponseEntity<ResponseStructure<List<Author>>>(structure, HttpStatus.OK);
	}

	//get author by id
	public ResponseEntity<ResponseStructure<Author>> getAuthorById(int id){
		Optional<Author> opt= authorDao.getAuthorById(id);
		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Author>>(structure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

	//update author
	public ResponseEntity<ResponseStructure<Author>> updateAuthor(Author author){
		Author recievedAuthor = authorDao.updateAuthor(author);
		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedAuthor);
		return new ResponseEntity<ResponseStructure<Author>>(structure, HttpStatus.OK);
	}

	//delete author
	public ResponseEntity<ResponseStructure<Author>> deleteAuthor(int id){
		Optional<Author> opt= authorDao.getAuthorById(id);
		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		if(opt.isPresent()) {
			Author author =opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(opt.get());
			authorDao.deleteAuthor(author);
			return new ResponseEntity<ResponseStructure<Author>>(structure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
}
