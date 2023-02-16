package com.home.spring.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.spring.util.DBconnection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.home.spring.member.MemberDAO.";
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "memberJoin", memberDTO);
	}
	
	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "memberRoleAdd" , memberDTO);
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "memberLogin", memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+ "memberUpdate", memberDTO);
	}
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "memberDetail", memberDTO);
	}
}
