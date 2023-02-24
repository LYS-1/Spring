package com.home.spring.board;

import com.home.spring.util.BoardFilesDTO;

public interface BoardDAO extends BbsDAO{

	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;
	
	//files insert
	public int setBoardImgAdd(BoardFilesDTO boardFilesDTO) throws Exception;
}
