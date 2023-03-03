package com.home.spring.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.home.spring.board.BbsDTO;

import com.home.spring.member.MemberDTO;
import com.home.spring.util.Pagination;

@Controller
@RequestMapping("/bankBookComment/*")
public class BankBookCommentController {
	
	@Autowired
	private BankBookCommentService bankBookCommentService;
	
	@GetMapping("list")
	public ModelAndView getBoardList(Pagination pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BbsDTO> ar = bankBookCommentService.getBoardList(pager);
		mv.addObject("result", ar);
		mv.addObject("pager", pager);
		mv.setViewName("/common/bankBookCommentResult");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setReplyAdd(BankBookCommentDTO commentDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
			
		//commentDTO.setWriter(memberDTO.getId());
		commentDTO.setWriter("testlsy");
		
		int result = bankBookCommentService.setCommentAdd(commentDTO);
		
		
		mv.addObject("result", result);
		mv.setViewName("/common/ajaxResult");
		
		return mv;
	}
}
