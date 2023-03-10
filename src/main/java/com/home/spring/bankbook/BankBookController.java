package com.home.spring.bankbook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.home.spring.util.Pager;
import com.home.spring.util.Pagination;



@Controller
@RequestMapping("/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list")
	public ModelAndView getBankBookList(Pagination pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BankBookDTO> ar = bankBookService.getBankBookList(pager);
		
		mv.setViewName("/bankBook/list");
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		
		return mv;
	}
	
	
	@RequestMapping(value = "detail")
	public ModelAndView getBankbookDetail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		
		mv.setViewName("/bankBook/detail");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
	}
	
	//move to insert form
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void setBankBookInsert() {
		
	}
	//insert data into DB
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView setBankBookInsert(BankBookDTO bankBookDTO, MultipartFile pic, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		ServletContext servletContext = session.getServletContext();
		System.out.println(servletContext);
		int result = bankBookService.setBankBookInsert(bankBookDTO, pic);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	//move to update form
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		mv.setViewName("/bankBook/update");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
	}
	//insert data into DB
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		mv = new ModelAndView();
		
		int result = bankBookService.setBankBookUpdate(bankBookDTO);
		
		mv.setViewName("redirect:./detail?bookNumber="+bankBookDTO.getBookNumber());
		
		return mv;
	}
//	
//	//move to delete form
//	@RequestMapping(value = "delete", method = RequestMethod.GET)
//	public void setBankBookDelete() {
//		
//	}
//	//insert data into DB
//	@RequestMapping(value = "delete", method = RequestMethod.POST)
//	public ModelAndView setbankBookDelete(BankBookDTO bankBookDTO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		int result = bankBookService.setBankBookDelete(bankBookDTO);
//		
//		mv.setViewName("redirect:./list");
//		
//		return mv;
//	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setbankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
}
