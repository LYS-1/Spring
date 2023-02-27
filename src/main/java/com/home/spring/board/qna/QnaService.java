package com.home.spring.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.home.spring.board.BbsDAO;
import com.home.spring.board.BbsDTO;
import com.home.spring.board.BoardDAO;
import com.home.spring.board.BoardDTO;
import com.home.spring.board.BoardFileDTO;
import com.home.spring.board.BoardService;
import com.home.spring.util.FileManager;
import com.home.spring.util.Pagination;

@Repository
public class QnaService implements BoardService{
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	
	
	@Override
	public List<BbsDTO> getBoardList(Pagination pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		
		Long totalCount = qnaDAO.getTotalCount(pager);
		
		pager.makeBlock(totalCount);
		return qnaDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile [] multipartFiles, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		int result = qnaDAO.setBoardAdd(bbsDTO);
		
		//file hdd에 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		
		
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
			result = qnaDAO.setBoardFileAdd(boardFileDTO);
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
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
		int result = qnaDAO.setBoardDelete(bbsDTO);
		
		if(result > 0) {
			
			
			String realPath = session.getServletContext().getRealPath("resources/upload/qna");
			
			for(BoardFileDTO boardFileDTO : ar) {
				boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
			
		}
				
		return result;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardDetail(boardDTO);
	}
	
	//reply insert
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception{
		//qnaDTO
		// num : 부모의 글 번호 writer, title, contents : 답글로 입력한 값
		// ref : null step : null depth : null
		//1. 부모의 정보를 조회해와야함
		QnaDTO parent = (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		
		// ref : 부모의ref
		qnaDTO.setRef(parent.getRef());
		// step : 부모의 step + 1
		qnaDTO.setStep(parent.getStep()+1);
		// depth : 부모의 step + 1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. step update
		int result = qnaDAO.setStepUpdate(parent);
//		String imo = "";
//		for (int i = 0; i < qnaDTO.getDepth(); i ++) {
//			imo = imo + "↳";
//		}
		//3. 답글 insert
		result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
	}

}
