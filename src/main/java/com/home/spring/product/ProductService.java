package com.home.spring.product;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.spring.product.option.ProductOptionDAO;
import com.home.spring.product.option.ProductOptionDTO;

@Service
public class ProductService {
	//강한 결합도
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductOptionDAO productOptionDAO;
	
	public int setAddProduct(ProductDTO productDTO,List<ProductOptionDTO> ar) throws Exception{
		//product테이블에 상품등록 및 옵션 등록
		int productNum = productDAO.getProductNum().intValue();
		productDTO.setPro_num(productNum);
		int result = productDAO.addProduct(productDTO);
		
		if(ar != null){
			for(ProductOptionDTO productOptionDTO : ar) {
				productOptionDTO.setOption_num(productNum);
				result = productOptionDAO.addProductOption(productOptionDTO);
			}
		}
		
		return result;
	}
	
	public List<ProductDTO> getProductList() throws Exception{
		return productDAO.getProduct();
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductDetail(productDTO);
	}
	public int setProductDelete(Integer pro_num) throws Exception{
		return productDAO.setProductDelete(pro_num);
	}
	//약한 결합도
	public void setProductOptionDAO(ProductOptionDAO productOptionDAO) {
		this.productOptionDAO = productOptionDAO;
	}
	
	public int addProductOption(ProductOptionDTO productOptionDTO, List<ProductOptionDTO> listOption) throws Exception{
		
		int productNum = productOptionDAO.getMax();
		
		productOptionDTO.setPro_num(productNum);
		
		int result = productOptionDAO.addProductOption(productOptionDTO);
		
		for(ProductOptionDTO OptionDTO : listOption) {
			OptionDTO.setPro_num(productNum);
			result = productOptionDAO.addProductOption(OptionDTO);
		}
		
		return result;
	}
}
