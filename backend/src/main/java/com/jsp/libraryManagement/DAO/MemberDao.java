package com.jsp.libraryManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.libraryManagement.Entity.Member;
import com.jsp.libraryManagement.Repository.MemberRepository;

@Repository
public class MemberDao {
	@Autowired
	private MemberRepository memberRepository;

	//save member
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}

	//get all members
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}

	//get member by id
	public Optional<Member> getMemberById(int id) {
		return memberRepository.findById(id);
	}

	//update member
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}

	//delete member
	public void deleteMember(Member member){
		memberRepository.delete(member);;
	}
}
