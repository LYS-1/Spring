package com.home.spring.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.home.spring.member.MemberDTO;


public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	//role이 admin이면 통과
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		if(memberDTO != null) {
			if(memberDTO.getRoleDTO().getRoleName().equals("ADMIN")) {
				return true;
			}
		}
		//로그인 X or ADMIN X
		request.setAttribute("msg", "권한이 없습니다.");
		request.setAttribute("url", "../");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
		view.forward(request, response);
		return false;
	}
}
