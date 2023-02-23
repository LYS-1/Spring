package com.home.spring.board;


public interface BoardDAO extends BbsDAO{

	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;
	
}
