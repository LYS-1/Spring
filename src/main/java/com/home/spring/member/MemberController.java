package com.home.spring.member;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberAgree")
	public void setMemberAgree() throws Exception{

	}
	
	@PostMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boolean check = memberService.getMemberIdCheck(memberDTO);
		
		mv.addObject("result", check);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		
		mv.addObject("dto" ,memberDTO);
		
		mv.setViewName("/member/memberPage");
		
		return mv;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public ModelAndView getMemberUpdate(MemberDTO memberDTO) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", memberDTO);
		System.out.println(memberDTO.getName());
		mv.setViewName("/member/memberUpdate");
		return mv;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView getMemberUpdate(MemberDTO memberDTO , ModelAndView mv, HttpSession session) throws Exception {
		mv = new ModelAndView();
		MemberDTO gMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(gMemberDTO.getId());
		
		int result = memberService.setMemberUpdate(memberDTO);
//		session.setAttribute("member", memberDTO);
		mv.setViewName("redirect:/member/memberPage");
		
		return mv;
	}
	
	
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void setMemberJoin() {
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String setMemberJoin(MemberDTO memberDTO) throws Exception {
		System.out.println("pw : " + memberDTO.getPw());
		int result = memberService.setMemberJoin(memberDTO);
		System.out.println(result > 0);
		return "redirect:/";
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public ModelAndView getMemberLogin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/memberLogin");
		
//		Cookie[] cookies = request.getCookies();
//	
//		for(Cookie cookie:cookies) {
//			System.out.println("name : " +cookie.getName());
//			System.out.println("value : " +cookie.getValue());
//			System.out.println("domain : " +cookie.getDomain());
//			System.out.println("path : " +cookie.getPath());
//			System.out.println("------------");
//			if(cookie.getName().equals("rememberID")){
//				mv.addObject("rememberID", cookie.getValue());
//				break;
//			}
//		}
		return mv;
	}
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request, String remember, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(remember != null && remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberID", memberDTO.getId());
			cookie.setMaxAge(60*60*24*7);
			
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("rememberID", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		memberDTO = memberService.getMemberLogin(memberDTO);
		if(memberDTO != null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("member", memberDTO);
		}

		mv.setViewName("redirect:/");
		
		
		return mv;
	}
	@RequestMapping(value="memberLogout", method=RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}
}
