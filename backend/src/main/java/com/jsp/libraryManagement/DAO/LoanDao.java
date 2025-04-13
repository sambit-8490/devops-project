package com.jsp.libraryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.libraryManagement.Entity.Loan;
import com.jsp.libraryManagement.Repository.LoanRepository;

@Repository
public class LoanDao {
	@Autowired
	private LoanRepository loanRepository;

	//save loan
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}

	//get all loans
	public List<Loan> getAllLoans(){
		return loanRepository.findAll();
	}

	//get loan by id
	public Optional<Loan> getLoanById(int id) {
		return loanRepository.findById(id);
	}

	//update loan
	public Loan updateLoan(Loan loan) {
		return loanRepository.save(loan);
	}

	//delete loan
	public void deleteLoan(Loan loan){
		loanRepository.delete(loan);;
	}
}
