package com.home.spring.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.home.util.DBconnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.home.spring.product.ProductDAO.";
	
	public int setProductDelete(Integer productNum) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "setProductDelete", productNum);
	}
		
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

		return sqlSession.selectOne(NAMESPACE + "getProductDetail", productDTO);
	}
	
	public List<ProductDTO> getProduct() throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getProduct");
	}
	
	public int addProduct(ProductDTO productDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "addProduct", productDTO);
	}
	

}
