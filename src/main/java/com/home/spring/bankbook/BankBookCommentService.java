package com.home.spring.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.home.spring.board.BbsDAO;
import com.home.spring.board.BbsDTO;
import com.home.spring.board.BbsService;
import com.home.spring.member.MemberDTO;
import com.home.spring.util.Pagination;

@Service
public class BankBookCommentService implements BbsService{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	//private BankBookCommentDAO bankBookCommentDAO;
	
	@Override
	public List<BbsDTO> getBoardList(Pagination pager) throws Exception {
		// TODO Auto-generated method stub
		
		pager.makeRow();
		Long totalCount = bankBookCommentDAO.getTotalCount(pager);
		
		pager.makeBlock(totalCount);
		
		return bankBookCommentDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile files[], HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return bankBookCommentDAO.setBoardUpdate(bbsDTO);
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return bankBookCommentDAO.setBoardDelete(bbsDTO);
	}

	public int setCommentAdd(BankBookCommentDTO commentDTO)throws Exception{
		return bankBookCommentDAO.setCommentAdd(commentDTO);
	}
	
}
