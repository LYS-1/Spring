package com.home.spring.board.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.home.spring.bankbook.BankBookImgDTO;
import com.home.spring.board.BbsDAO;
import com.home.spring.board.BbsDTO;
import com.home.spring.board.BoardDAO;
import com.home.spring.board.BoardDTO;
import com.home.spring.board.BoardService;
import com.home.spring.util.BoardFilesDTO;
import com.home.spring.util.FileManager;
import com.home.spring.util.Pagination;

@Repository
public class NoticeService implements BoardService{

	@Autowired
	private BoardDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	@Override
	public List<BbsDTO> getBoardList(Pagination pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		Long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeBlock(totalCount);
		return noticeDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile files[]) throws Exception {
		// TODO Auto-generated method stub
		int result = noticeDAO.setBoardAdd(bbsDTO);
		for(int i = 0; i < files.length; i ++) {	
			if(!files[i].isEmpty()) {
				String realPath = servletContext.getRealPath("resources/upload/Notice");
				System.out.println(realPath);
				String fileName = fileManager.saveFile(files[i], realPath);
				//filesdto
				BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
				boardFilesDTO.setFileName(fileName);
				boardFilesDTO.setOriName(files[i].getOriginalFilename());
				boardFilesDTO.setNum(bbsDTO.getNum());
				//imgadd추가
				result = noticeDAO.setBoardImgAdd(boardFilesDTO);
			}
		}
		
		return result;
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
		return noticeDAO.getBoardDetail(boardDTO);
	}
	
}
