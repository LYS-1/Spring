package com.home.spring.bookproduct;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BookProductDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.home.spring.bookproduct.BookProductDAO.";
	
	public List<BookProductDTO> getBookProductList() {
		return sqlSession.selectList(NAMESPACE + "getBookProductList");
	}
}
