package com.jsp.libraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.libraryManagement.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
