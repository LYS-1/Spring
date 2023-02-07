package com.home.spring.bankbook;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.spring.MyTestCase;

public class BankBookDAOTest extends MyTestCase{
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception{
		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
		
		assertNotEquals(0, ar.size());
	}
	@Test
	public void getBankBookDetailTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(10023L);
		bankBookDTO.setBookName("test");
		bankBookDTO.setBookDetail("test");
		bankBookDTO.setBookRate(0.0);
		bankBookDTO.setBookSale(1);
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		
		assertNotNull(bankBookDTO);
	}
	@Test
	public void setBankBookInsertTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(10023L);
		bankBookDTO.setBookName("test");
		bankBookDTO.setBookDetail("test");
		bankBookDTO.setBookRate(0.0);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.setBankBookInsert(bankBookDTO);
		
		assertNotEquals(0, result);
	}
	@Test
	public void setBankBookDeleteTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1L);
		int result = bankBookDAO.setBankBookDelete(bankBookDTO);
		
		assertNotEquals(1, result);
	}
	@Test
	public void setBankBookUpdate() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(10023L);
		bankBookDTO.setBookName("test");
		bankBookDTO.setBookDetail("test");
		bankBookDTO.setBookRate(0.0);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.setBankBookUpdate(bankBookDTO);
		
		assertNotEquals(0, result);
	}
}
