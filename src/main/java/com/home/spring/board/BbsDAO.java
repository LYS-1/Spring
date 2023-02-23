package com.home.spring.board;

import java.util.List;

import com.home.spring.util.Pagination;

public interface BbsDAO {
	//list
	public List<BbsDTO> getBoardList(Pagination pager) throws Exception;
	//insert(add)
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception;
	//update
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception;
	//delete
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception;
	//totalCount
	public Long getTotalCount(Pagination pager) throws Exception;
}
