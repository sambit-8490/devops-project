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
import com.jsp.libraryManagement.Entity.Loan;
import com.jsp.libraryManagement.Service.LoanService;

@CrossOrigin("*")
@RestController
@RequestMapping("/loan")
public class LoanController {
	@Autowired
	private LoanService loanService ;

	//save loan
	@PostMapping
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(@RequestBody Loan loan){
		return loanService.saveLoan(loan);
	}

	//get all loans
	@GetMapping("/loans")
	public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoans(){
		return  loanService.getAllLoans();
	}

	//get loan by id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> getLoanById(@PathVariable int id){
		return loanService.getLoanById(id);
	}

	@PutMapping
	//update loan
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(@RequestBody Loan loan){
		return loanService.updateLoan(loan);
	}

	//delete loan
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(@PathVariable int id){
		return loanService.deleteLoan(id);
	}	
}
