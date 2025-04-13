package com.jsp.libraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.libraryManagement.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
