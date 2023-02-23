package com.home.spring.board;

public interface BoardService extends BbsService {
	
	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;
}
