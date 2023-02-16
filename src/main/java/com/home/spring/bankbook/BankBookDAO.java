package com.home.spring.bankbook;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.spring.util.Pager;
import com.home.spring.util.Pagination;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.home.spring.bankbook.BankBookDAO.";
	
	public Long getBankBookCount(Pagination pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getBankBookCount", pager);
	}

	public List<BankBookDTO> getBankBookList(Pagination pager) throws Exception{
		return sqlSession.selectList(NAMESPACE + "getBankBookList", pager);
	}
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "getBankBookDetail", bankBookDTO);
	}
	
	public int setBankBookInsert(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "setBankBookInsert", bankBookDTO);
	}
	
	public int setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE + "setBankBookUpdate", bankBookDTO);		
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.delete(NAMESPACE + "setBankBookDelete", bankBookDTO);
	}
	
	public int setBankBookImgAdd(BankBookImgDTO bankBookImgDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "setBankBookImgAdd", bankBookImgDTO);
		
	}
}
