package com.home.spring.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public List<BankBookDTO> getBankBookList() throws Exception{
		return bankBookDAO.getBankBookList();
	}

	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getBankBookDetail(bankBookDTO);
	}
	
	public int setBankBookInsert(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookInsert(bankBookDTO);
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookUpdate(bankBookDTO);
	}
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}
}
