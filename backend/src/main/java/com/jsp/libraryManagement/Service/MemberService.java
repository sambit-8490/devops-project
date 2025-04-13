package com.jsp.libraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.libraryManagement.DAO.MemberDao;
import com.jsp.libraryManagement.DTO.ResponseStructure;
import com.jsp.libraryManagement.Entity.Member;
import com.jsp.libraryManagement.Exception.IdNotFoundException;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;

	//save member
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member member){
		Member recievedMember = memberDao.saveMember(member);

		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.CREATED.value()); //201
		structure.setMessage("success");
		structure.setData(recievedMember);
		return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.CREATED);
	}

	//get all members
	public ResponseEntity<ResponseStructure<List<Member>>> getAllMembers(){
		List<Member> recievedMember = memberDao.getAllMembers();
		ResponseStructure<List<Member>> structure = new ResponseStructure<List<Member>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedMember);
		return new ResponseEntity<ResponseStructure<List<Member>>>(structure, HttpStatus.OK);
	}

	//get member by id
	public ResponseEntity<ResponseStructure<Member>> getMemberById(int id){
		Optional<Member> opt= memberDao.getMemberById(id);
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

	//update member
	public ResponseEntity<ResponseStructure<Member>> updateMember(Member member){
		Member recievedLoan = memberDao.updateMember(member);
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(recievedLoan);
		return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.OK);
	}

	//delete member
	public ResponseEntity<ResponseStructure<Member>> deleteMember(int id){
		Optional<Member> opt= memberDao.getMemberById(id);
		
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		if(opt.isPresent()) {
			Member member =opt.get();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(opt.get());
			memberDao.deleteMember(member);
			return new ResponseEntity<ResponseStructure<Member>>(structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
}
