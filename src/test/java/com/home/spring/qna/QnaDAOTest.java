package com.home.spring.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.spring.MyTestCase;
import com.home.spring.board.BbsDTO;
import com.home.spring.board.BoardDTO;
import com.home.spring.board.notice.NoticeDTO;
import com.home.spring.board.qna.QnaDAO;
import com.home.spring.board.qna.QnaDTO;
import com.home.spring.util.Pagination;

public class QnaDAOTest extends MyTestCase{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getTotalCountTest() throws Exception{
		Pagination pager = new Pagination();
		
		long count = qnaDAO.getTotalCount(pager);
		pager.setKind("writer");
		pager.setSearch("T");
		//pager.makeRow();
		//List<BbsDTO> ar = qnaDAO.getBoardList(pager);
		assertNotEquals(0, count);
	}
	@Test
	public void setInsertTest() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("test");
		qnaDTO.setContents("test");
		qnaDTO.setWriter("test");
		
		qnaDAO.setBoardAdd(qnaDTO);
	}
	
	@Test
	public void getBoardDetail() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(14L);
		
		BoardDTO dto = qnaDAO.getBoardDetail(qnaDTO);
		
		assertNotNull(dto.getNum());
	}
}
