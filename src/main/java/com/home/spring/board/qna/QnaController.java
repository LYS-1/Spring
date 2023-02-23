package com.home.spring.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.home.spring.board.BbsDTO;
import com.home.spring.board.BbsService;
import com.home.spring.util.Pagination;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private BbsService qnaService;
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public ModelAndView getBoardList(Pagination pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BbsDTO> ar = qnaService.getBoardList(pager);

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("/board/list");
		
		return mv;
	}
}
