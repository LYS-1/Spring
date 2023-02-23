package com.home.spring.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.spring.MyTestCase;
import com.home.spring.board.BbsDTO;
import com.home.spring.board.notice.NoticeDAO;
import com.home.spring.util.Pagination;

public class NoticeDAOTest extends MyTestCase{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getTotalCountTest() throws Exception{
		Pagination pager = new Pagination();
		
		long count = noticeDAO.getTotalCount(pager);
		pager.setKind("writer");
		pager.setSearch("T");
		//pager.makeRow();
		//List<BbsDTO> ar = noticeDAO.getBoardList(pager);
		assertNotEquals(0, count);
	}
}
