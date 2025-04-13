package com.jsp.libraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.libraryManagement.Entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
