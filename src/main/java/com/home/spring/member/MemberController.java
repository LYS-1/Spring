package com.home.spring.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberJoin")
	public String getMemberJoin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id("test");
		memberDTO.setMember_pw("test");
		memberDTO.setMember_name("test");
		memberDTO.setMember_address("test");
		memberDTO.setMember_phone("test");
		memberDTO.setMember_email("test");
		int result = memberService.memberJoin(memberDTO);
		System.out.println(result > 0);
		return "/member/memberJoin";
	}
	
	@RequestMapping(value = "memberLogin")
	public void getMemberLogin() {
		
	}
	@RequestMapping(value = "memberPage")
	public ModelAndView getMemberPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/memberPage");
		return mv;
	}
}
