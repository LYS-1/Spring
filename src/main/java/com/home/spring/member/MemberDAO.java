package com.home.spring.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.company.home.util.DBconnection;

@Repository
public class MemberDAO {
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		Connection con = DBconnection.getConnection();
		
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDTO.getMember_id());
		ps.setString(2, memberDTO.getMember_pw());
		ps.setString(3, memberDTO.getMember_name());
		ps.setString(4, memberDTO.getMember_address());
		ps.setString(5, memberDTO.getMember_phone());
		ps.setString(6, memberDTO.getMember_email());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
}
