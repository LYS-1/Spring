package com.home.spring.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.home.spring.board.BbsDTO;
import com.home.spring.board.BoardDAO;
import com.home.spring.board.BoardDTO;
import com.home.spring.board.BoardFileDTO;
import com.home.spring.board.BoardService;
import com.home.spring.util.FileManager;
import com.home.spring.util.Pagination;

@Service
public class NoticeService implements BoardService{

	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	


	
	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardFileDetail(boardFileDTO);
	}

	@Override
	public List<BbsDTO> getBoardList(Pagination pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		Long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeBlock(totalCount);
		return noticeDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile multipartFiles[], HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int result = noticeDAO.setBoardAdd(bbsDTO);
		
		//file hdd에 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/board");
		
		
		for(MultipartFile multipartFile: multipartFiles) {
			if(multipartFile.isEmpty()) {
				
				continue;
			}
			
			String fileName = fileManager.saveFile(multipartFile, realPath);
			
			//db insert
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			result = noticeDAO.setBoardFileAdd(boardFileDTO);
			System.out.println(result);
		}
		
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO, MultipartFile[] multipartFile, HttpSession session, Long[] fileNums)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getBoardDetail(boardDTO);
	}
	
}
