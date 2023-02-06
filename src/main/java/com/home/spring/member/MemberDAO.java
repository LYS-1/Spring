package com.home.spring.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.home.util.DBconnection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.home.spring.member.MemberDAO.";
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "memberJoin", memberDTO);
	}
	
}
