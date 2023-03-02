package com.home.spring.interceptors;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.home.spring.board.BoardDTO;
import com.home.spring.board.notice.NoticeDAO;
import com.home.spring.board.qna.QnaDAO;
import com.home.spring.member.MemberDTO;

@Component
public class OwnerCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private QnaDAO qnaDAO;
	
	//업데이트도 쓰고 삭제도 쓰기 위해서 => 삭제는 실행 전에 필요함.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Long num = Long.parseLong(request.getParameter("num"));
		
		//URI (EX. /notice/update)
		String uri = request.getRequestURI();
		// 두번째로 '/'를 만나는 인덱스값
		//int idx = uri.indexOf("/", 1);
		// 인덱스 1 ~ 두번째로 '/'만나는 인덱스 미만의 인덱스로 substring
		String boardName = uri.substring(1, uri.lastIndexOf("/"));
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		if(boardName.equals("notice")) {
			boardDTO = noticeDAO.getBoardDetail(boardDTO);
		}else {
			boardDTO = qnaDAO.getBoardDetail(boardDTO);
		}
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			request.setAttribute("msg", "작성자만 수정 가능합니다.");
			request.setAttribute("url", "./list");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			return false;
		}
		
		
		return true;
		// /notice/update
	}
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		
//		//1. 로그인
//		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
//		
//		//2. BoardDTO 
//		Map<String, Object> map = modelAndView.getModel();
//		BoardDTO boardDTO = (BoardDTO)map.get("dto");
//		//map.keySet().iterator();
//		
//		//3. check
//				
//		if(memberDTO == null || !boardDTO.getWriter().equals(memberDTO.getId())) {
//			modelAndView.addObject("msg", "작성자만 수정 가능합니다.");
//			modelAndView.addObject("url", "./list");
//			modelAndView.setViewName("/common/result");
//		}
//		
//		super.postHandle(request, response, handler, modelAndView);
//	}

	
}
