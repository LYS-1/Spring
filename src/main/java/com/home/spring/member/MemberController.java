package com.home.spring.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberPage")
	public ModelAndView getMemberPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/memberPage");
		return mv;
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void setMemberJoin() {
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String setMemberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberService.setMemberJoin(memberDTO);
		System.out.println(result > 0);
		return "redirect:./memberPage";
	}
	
	@RequestMapping(value = "memberLogin")
	public void getMemberLogin() {
		
	}
	
}
