package com.home.spring.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.home.spring.board.BbsDTO;
import com.home.spring.board.BoardDTO;
import com.home.spring.board.BoardFileDTO;
import com.home.spring.member.MemberDTO;
import com.home.spring.util.Pagination;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName(){
		return "qna";
	}
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public ModelAndView getBoardList(Pagination pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("/board/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/add");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile []addFiles, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardAdd(qnaDTO, addFiles, session);
		
		String msg = "등록 실패";
		if(result > 0) {
			msg = "등록 성공";
		}
		
		
		mv.addObject("msg", msg);
		mv.addObject("url", "./list");
		mv.setViewName("/common/result");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		BoardDTO boardDTO = qnaService.getBoardDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("/board/detail");
		
		return mv;
	}
	
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/board/reply");
		
		return mv;
	}
	
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setReplyAdd(qnaDTO);
		
		String msg = "등록 실패";
		if(result > 0) {
			msg = "등록 성공";
		}
		
		
		mv.addObject("msg", msg);
		mv.addObject("url", "./detail?num=" + qnaDTO.getNum());
		mv.setViewName("/common/result");
		
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		
		System.out.println("delete진입");
		
		
		int result = qnaService.setBoardDelete(bbsDTO, session);
		
		
		String msg = "삭제 실패";
		
		if(result > 0) {
			msg = "삭제 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("url", "./list");
		
		return mv;
	}
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		
		mv.addObject("boardFile", boardFileDTO);
		mv.setViewName("fileDownView");
		
		return mv;
	}
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardDTO = qnaService.getBoardDetail(boardDTO);
		mv.addObject("dto" , boardDTO);
		
		mv.setViewName("/board/update");
		
		return mv;
	}
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO, MultipartFile addFiles[], HttpSession session, Long fileNum[])throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardUpdate(boardDTO, addFiles, session, fileNum);
		
		mv.setViewName("/common/result");
		mv.addObject("msg", "수정 성공");
		mv.addObject("url", "./list");
		return mv;
	}
	
	@PostMapping("boardFileDelete")
	public ModelAndView setBoardFileDelete(Long fileNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardFileDelete(fileNum);
		mv.addObject("result", result);
		mv.setViewName("/common/ajaxResult");
		
		return mv;
	}
}
