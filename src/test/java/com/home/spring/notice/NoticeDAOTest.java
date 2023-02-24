package com.home.spring.notice;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.spring.MyTestCase;
import com.home.spring.board.BbsDTO;
import com.home.spring.board.BoardDTO;
import com.home.spring.board.notice.NoticeDAO;
import com.home.spring.board.notice.NoticeDTO;
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
	
	@Test
	public void setBoardAdd() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Title1");
		noticeDTO.setWriter("Writer1");
		noticeDTO.setContents("Contents1");
		
		int result = noticeDAO.setBoardAdd(noticeDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void getBoardDetail() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		
		BoardDTO dto = noticeDAO.getBoardDetail(noticeDTO);
		
		assertNotNull(dto.getNum());
	}
}
