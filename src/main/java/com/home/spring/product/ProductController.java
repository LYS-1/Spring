package com.home.spring.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@RequestMapping(value = "list")
	public String getProductList() throws Exception {
		List<ProductDTO> ar = productService.getProductList();
		
		System.out.println(ar.size() > 0);
		
		return "/product/productList";
	}
	
	@RequestMapping(value = "detail")
	public String getProductDetail() {
		System.out.println("product detail");
		return "/product/productDetail";
	}
	
	@RequestMapping(value = "productAdd")
	public void getProductAdd() {
		
	}
	
	@RequestMapping(value = "update")
	public ModelAndView getUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
}
