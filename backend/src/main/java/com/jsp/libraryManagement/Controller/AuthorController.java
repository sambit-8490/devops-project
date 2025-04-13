package com.jsp.libraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.libraryManagement.DTO.ResponseStructure;
import com.jsp.libraryManagement.Entity.Author;
import com.jsp.libraryManagement.Service.AuthorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService ;

	//save author
	@PostMapping
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(@RequestBody Author author){
		return authorService.saveAuthor(author);
	}

	//get all authors
	@GetMapping("/authors")
	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthor(){
		return  authorService.getAllAuthors();
	}

	//get author by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Author>> getAuthorById(@PathVariable int id){
		return authorService.getAuthorById(id);
	}

	@PutMapping
	//update author
	public ResponseEntity<ResponseStructure<Author>> updateAuthor(@RequestBody Author author){
		return authorService.updateAuthor(author);
	}

	//delete author
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Author>> deleteAuthor(@PathVariable int id){
		return authorService.deleteAuthor(id);
	}		
}