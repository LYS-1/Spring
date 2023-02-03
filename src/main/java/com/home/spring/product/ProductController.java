package com.home.spring.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@RequestMapping(value = "list")
	public ModelAndView getProductList() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> ar = productService.getProductList();
		
		mv.setViewName("/product/productList");
		mv.addObject("productList", ar);
		
		return mv;
	}
	//HttpServletRequest request, HttpServletResponse response
	//Integer num, @RequestParam(value = "n") String name, @RequestParam(value = "a", defaultValue = "1", required = false) int age
	@RequestMapping(value = "detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		//파라미터 이름이 setter의 이름과 같아야함 dto변수명 = 테이블의 컬럼명 = 파라미터 값
		System.out.println("productDetail");
		
		//String num = request.getParameter("num");
		//ProductDTO productDTO = new ProductDTO();
		
		//productDTO.setPro_num(Integer.parseInt(num));
		productDTO = productService.getProductDetail(productDTO);
		
		model.addAttribute("productDTO", productDTO);
		
		System.out.println(productDTO != null);
		return "/product/productDetail";
	}
	
	@RequestMapping(value = "productAdd", method = RequestMethod.GET)
	public void getProductAdd() {
		//페이지로 이동하는 메서드
	}
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String getProductAdd(ProductDTO productDTO) throws Exception{
		//페이지에서 값 받아오는 메서드
		int result = productService.setAddProduct(productDTO, null);
		System.out.println(result == 1);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "update")
	public ModelAndView getUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
}