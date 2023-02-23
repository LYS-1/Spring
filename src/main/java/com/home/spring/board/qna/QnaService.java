package com.home.spring.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.spring.board.BbsDAO;
import com.home.spring.board.BbsDTO;
import com.home.spring.board.BoardDTO;
import com.home.spring.board.BoardService;
import com.home.spring.util.Pagination;

@Repository
public class QnaService implements BoardService{
	@Autowired
	private BbsDAO qnaDAO;
	
	@Override
	public List<BbsDTO> getBoardList(Pagination pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		
		Long totalCount = qnaDAO.getTotalCount(pager);
		pager.makeBlock(totalCount);
		return qnaDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
