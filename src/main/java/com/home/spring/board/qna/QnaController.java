package com.home.spring.board.qna;

import java.util.List;

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
import com.home.spring.board.BbsService;
import com.home.spring.board.BoardDTO;
import com.home.spring.board.BoardService;
import com.home.spring.board.notice.NoticeDTO;
import com.home.spring.util.Pagination;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName(){
		return "QNA";
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
	
	@GetMapping(value="add")
	public ModelAndView setBoardAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/add");
		return mv;
	}
	
	@PostMapping(value="add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile files[]) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardAdd(qnaDTO, files);
		
		String msg = "등록 실패";
		if(result > 0) {
			msg = "등록 성공";
		}
		
		
		mv.addObject("msg", msg);
		mv.addObject("url", "./list");
		mv.setViewName("/common/result");
		return mv;
	}
	
	@GetMapping(value="detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		BoardDTO boardDTO = qnaService.getBoardDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("/board/detail");
		
		return mv;
	}
	
	@GetMapping(value="reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/board/reply");
		
		return mv;
	}
	
	@PostMapping(value="reply")
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
}
