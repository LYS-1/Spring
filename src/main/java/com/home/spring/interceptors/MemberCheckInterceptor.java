package com.home.spring.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//controller진입 전
		//return이 true라면 다음 controller로 진행
		//return이 false라면 다음 controller로 진행 X
		System.out.println("Controller 진입 전 check");
		Object obj = request.getSession().getAttribute("member");
		if(obj == null) {
			//response.sendRedirect("/member/memberLogin");
			request.setAttribute("msg", "권한이 없습니다.");
			request.setAttribute("url", "../member/memberLogin");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			return false;
		}else {
			return true;
		}
			
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		//controller에서 리턴 후 ds 전
		System.out.println("controller에서 리턴 후 ds 진입 전");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//jsp 랜더링 후
		System.out.println("jsp 랜더링 후");
	}
	
}
