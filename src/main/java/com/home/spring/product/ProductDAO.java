package com.home.spring.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.home.spring.util.DBconnection;

@Repository
public class ProductDAO {
	
	public int getMax() throws Exception{
		Connection con = DBconnection.getConnection();
		String sql = "SELECT MAX(PRO_NUM) FROM PRODUCT";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		int result = 0;
		
		if(rs.next()) {
			result = rs.getInt("MAX(PRO_NUM)");
		}
		return result;
	}
	public Long getProductNum()throws Exception{
		
		Connection con = DBconnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBconnection.disconnection(con, ps, rs);
		
		return num;
		
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		
		Connection con = DBconnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCT WHERE PRO_NUM = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, productDTO.getPro_num());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setPro_num(rs.getInt("PRO_NUM"));
			productDTO.setPro_introduce(rs.getString("PRO_INTRODUCE"));
			productDTO.setRating(rs.getDouble("RATING"));
			productDTO.setTag(rs.getString("TAG"));
			productDTO.setPro_name(rs.getString("PRO_NAME"));
		}
		
		return productDTO;
		
	}
	public List<ProductDTO> getProduct() throws Exception{
		ArrayList<ProductDTO> arDTO = new ArrayList<ProductDTO>();
		
		Connection con = DBconnection.getConnection();
		
		String sql = "SELECT PRO_NUM, PRO_NAME, RATING"
				+ " FROM PRODUCT ORDER BY PRO_NUM ASC";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setPro_num(rs.getInt("PRO_NUM"));
			productDTO.setPro_name(rs.getString("PRO_NAME"));
			productDTO.setRating(rs.getDouble("RATING"));
			
			arDTO.add(productDTO);
		}
		
		DBconnection.disconnection(con, ps, rs);
		
		return arDTO;
	}
	
	public int addProduct(ProductDTO productDTO) throws Exception{
		
		Connection con = DBconnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, productDTO.getPro_num());
		ps.setString(2, productDTO.getPro_introduce());
		if(productDTO.getRating() != null) {
		ps.setDouble(3, productDTO.getRating());}
		else {
			ps.setDouble(3, 0);
		}
		ps.setString(4, productDTO.getTag());
		ps.setString(5, productDTO.getPro_name());

		int result = ps.executeUpdate();
		
		return result;
	}
	
	
}
