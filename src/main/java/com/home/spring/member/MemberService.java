package com.home.spring.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.setMemberJoin(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		return result;
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		memberDTO = memberDAO.getMemberLogin(memberDTO);
		return memberDTO;
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		int result = memberDAO.setMemberUpdate(memberDTO);
		return result;
	}
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO) throws Exception{
		memberDTO = memberDAO.getMemberDetail(memberDTO);
		return memberDTO;
	}
}
