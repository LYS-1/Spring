package com.home.spring.bookproduct;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.spring.MyTestCase;

public class BookProductDAOTest extends MyTestCase{
	@Autowired
	private BookProductDAO bookProductDAO;
	
	@Test
	public void getBankBookListTest() throws Exception{
		List<BookProductDTO> ar = bookProductDAO.getBookProductList();
		
		assertNotEquals(0, ar.size());
	}
	
}
