package com.jsp.libraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.libraryManagement.DAO.BookDao;
import com.jsp.libraryManagement.DAO.LoanDao;
import com.jsp.libraryManagement.DAO.MemberDao;
import com.jsp.libraryManagement.DTO.ResponseStructure;
import com.jsp.libraryManagement.Entity.Book;
import com.jsp.libraryManagement.Entity.Loan;
import com.jsp.libraryManagement.Entity.Member;
import com.jsp.libraryManagement.Exception.IdNotFoundException;

@Service
public class LoanService {
	
	@Autowired
	LoanDao loanDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	MemberDao memberDao;
	//save loan
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan){
		Optional<Book> book=bookDao.getBookById(loan.getBook().getId());
		Optional<Member> member=memberDao.getMemberById(loan.getMember().getId());
		if(book.isPresent() && member.isPresent()) {
			Loan recievedLoan=loanDao.saveLoan(loan);
			recievedLoan.setBook(book.get());
			recievedLoan.setMember(member.get());
			ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
			structure.setStatusCode(HttpStatus.CREATED.value()); //201
			structure.setMessage("success");
			structure.setData(recievedLoan);
			return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new IdNotFoundException();
		}
		
	}


	//get all loans
	public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoans(){
		List<Loan> recievedLoan = loanDao.getAllLoans();
		ResponseStructure<List<Loan>> structure = new ResponseStructure<List<Loan>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedLoan);
		return new ResponseEntity<ResponseStructure<List<Loan>>>(structure, HttpStatus.OK);
	}

	//get loan by id
	public ResponseEntity<ResponseStructure<Loan>> getLoanById(int id){
		Optional<Loan> opt= loanDao.getLoanById(id);
		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

	//update loan
	public ResponseEntity<ResponseStructure<Loan>> updateLoan(Loan loan){
		Loan recievedLoan = loanDao.updateLoan(loan);
		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedLoan);
		return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.OK);
	}

	//delete loan
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(int id){
		Optional<Loan> opt= loanDao.getLoanById(id);
		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		if(opt.isPresent()) {
			Loan loan =opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(opt.get());
			loanDao.deleteLoan(loan);
			return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
}
