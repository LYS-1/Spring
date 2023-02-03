package com.home.spring.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired 
	private MemberDAO memberDAO;
	
	public int addMember(MemberDTO memberDTO) throws Exception{
		return memberDAO.addMember(memberDTO);
	}
	
	public ArrayList<MemberDTO> getMemberList() throws Exception {
		return memberDAO.getMemberList();
	}
	
	
}
