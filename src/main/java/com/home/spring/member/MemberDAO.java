package com.home.spring.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.home.spring.util.DBconnection;

@Repository
public class MemberDAO {
	
	//1. 회원 추가
	public int addMember(MemberDTO memberDTO) throws Exception{
		Connection con = DBconnection.getConnection();
		
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDTO.getMember_id());
		ps.setString(2, memberDTO.getMember_pw());
		ps.setString(3, memberDTO.getMember_name());
		ps.setString(4, memberDTO.getMember_address());
		ps.setString(5, memberDTO.getMember_phone());
		ps.setString(6, memberDTO.getMember_email());

		int result = ps.executeUpdate();
		
		DBconnection.disconnection(con, ps);
		
		return result;
	}
	public ArrayList<MemberDTO> getMemberList() throws Exception{
		
		MemberDTO memberDTO = new MemberDTO();
		
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		
		Connection con = DBconnection.getConnection();
		
		String sql = "SELECT * FROM MEMBER";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			memberDTO.setMember_id(rs.getString("MEMBER_ID"));
			memberDTO.setMember_pw(rs.getString("MEMBER_PW"));
			memberDTO.setMember_name(rs.getString("MEMBER_NAME"));
			memberDTO.setMember_address(rs.getString("MEMBER_ADDRESS"));
			memberDTO.setMember_phone(rs.getString("MEMBER_PHONE"));
			memberDTO.setMember_email(rs.getString("MEMBER_EMAIL"));
			
			ar.add(memberDTO);
		}
		
		DBconnection.disconnection(con, ps, rs);
		
		return ar;
	}
}
