package com.home.spring.board;

import java.util.List;

import com.home.spring.util.Pagination;

public interface BbsService {
	//list
	public List<BbsDTO> getBoardList(Pagination pager) throws Exception;
	//insert
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception;
	//update
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception;
	//delete
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception;
}
