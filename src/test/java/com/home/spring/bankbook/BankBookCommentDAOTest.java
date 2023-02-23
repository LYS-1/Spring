package com.home.spring.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.spring.MyTestCase;
import com.home.spring.board.BbsDTO;
import com.home.spring.util.Pagination;


public class BankBookCommentDAOTest extends MyTestCase{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void getBoardListTest() throws Exception{
		Pagination pager = new Pagination();
		pager.setBookNumber(421L);
		pager.setKind("contents");
		pager.setSearch("T");
		//long count = bankBookCommentDAO.getTotalCount(pager);
		pager.makeRow();
		List<BbsDTO> list = bankBookCommentDAO.getBoardList(pager);
		assertNotEquals(0, list.size());
	}
	
	

}
