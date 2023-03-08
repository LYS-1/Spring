package com.home.spring.board;

import java.util.List;

public interface BoardDAO extends BbsDAO{

	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;
	
	//files insert
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception;
	
	//boardfilelist
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;
	
	//boardfiledetail
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception;
	
	public int setBoardFileDelete(Long fileNum) throws Exception;
}
