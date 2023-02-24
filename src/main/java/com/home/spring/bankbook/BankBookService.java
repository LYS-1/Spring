package com.home.spring.bankbook;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.home.spring.util.FileManager;
import com.home.spring.util.Pager;
import com.home.spring.util.Pagination;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//테스트돌리면 안들어감
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BankBookDTO> getBankBookList(Pagination pager) throws Exception{
		
		Long totalCount = bankBookDAO.getBankBookCount(pager);
		
		pager.makeRow();
		
		pager.makeBlock(totalCount);
		
		return bankBookDAO.getBankBookList(pager);
	}

	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getBankBookDetail(bankBookDTO);
	}
	
	public int setBankBookInsert(BankBookDTO bankBookDTO, MultipartFile pic) throws Exception{
		int result = bankBookDAO.setBankBookInsert(bankBookDTO);
		
		//1. 파일의 서버의 hdd에 저장 
		//project 경로가 아닌 os에서 사용하는 경로
		if(!pic.isEmpty()) {
			String realPath = servletContext.getRealPath("resources/upload/bankBook");
			System.out.println(realPath);
			String fileName = fileManager.saveFile(pic, realPath);
			BankBookImgDTO bankBookImgDTO = new BankBookImgDTO();
			bankBookImgDTO.setFileName(fileName);
			bankBookImgDTO.setOriName(pic.getOriginalFilename());
			bankBookImgDTO.setBookNum(bankBookDTO.getBookNumber());
			
			result = bankBookDAO.setBankBookImgAdd(bankBookImgDTO);
		}
		return result; //bankBookDAO.setBankBookInsert(bankBookDTO);
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}
}
