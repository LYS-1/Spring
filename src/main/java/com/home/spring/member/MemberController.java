package com.home.spring.member;


import java.util.ArrayList;


import javax.servlet.http.HttpServlet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class memberController
 */
@Controller
@RequestMapping("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private MemberService memberService;
	
    @RequestMapping(value = "list")
	public String getMemberList(ArrayList<MemberDTO> ar, Model model) throws Exception {
    	ar = memberService.getMemberList();
    	model.addAttribute("list", ar);
    	
    	return "/member/memberList";
    }
	
    @RequestMapping(value = "join")
    public String getMemberJoin(MemberDTO memberDTO) throws Exception {
//    	int result = memberService.addMember(memberDTO);
//    	System.out.println(result == 1);
    	
    	return "/member/memberJoin";
    }

}
