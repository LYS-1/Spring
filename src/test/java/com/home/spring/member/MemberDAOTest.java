package com.home.spring.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.spring.MyTestCase;

public class MemberDAOTest extends MyTestCase{
	
	@Autowired
	MemberDAO memberDAO;
	
	@Test
	public void setMemberJoin() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("testfortest1");
		memberDTO.setPw("testfortest1");
		memberDTO.setAddress("testfortest1");
		memberDTO.setEmail("testfortest1");
		memberDTO.setPhone("testfortest1");
		memberDTO.setName("testfortest1");
		
		int result = memberDAO.setMemberJoin(memberDTO);
		
		assertNotEquals(0, result);
	}
}
