package com.home.spring.board.notice;

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
import com.home.spring.util.Pagination;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private BoardService noticeService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "NOTICE";
	}
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public ModelAndView getBoardList(Pagination pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BbsDTO> ar = noticeService.getBoardList(pager);

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
	public ModelAndView setBoardAdd(NoticeDTO noticeDTO, MultipartFile files[]) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setBoardAdd(noticeDTO, files);
		
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
	public ModelAndView getBoardDetail(NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		BoardDTO boardDTO = noticeService.getBoardDetail(noticeDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("/board/detail");
		
		return mv;
	}
}
