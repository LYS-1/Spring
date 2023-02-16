package com.home.spring.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.spring.MyTestCase;
import com.home.spring.util.Pagination;

public class ProductDAOTest extends MyTestCase{

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getProductTest(Pagination pager) throws Exception{
		List<ProductDTO> ar = productDAO.getProduct(pager);
		//단정문
		assertNotEquals(0, ar.size());
	}
//	@Test
//	public void getProductDetail() throws Exception{
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductNum(20000);
//		productDTO = productDAO.getProductDetail(productDTO);
//		assertNotNull(productDTO);
//		
//	}
//	@Test
//	public void setProductAdd() throws Exception{
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductNum(14310111);
//		productDTO.setProductDetail("test");
//		productDTO.setProductName("test");
//		int result = productDAO.setProductAdd(productDTO);
//		
//		assertNotEquals(0, result);;
//	}
}
