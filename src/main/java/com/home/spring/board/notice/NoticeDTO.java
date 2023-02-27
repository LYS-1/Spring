package com.home.spring.board.notice;

import java.util.List;

import com.home.spring.board.BoardDTO;
import com.home.spring.board.BoardFileDTO;

public class NoticeDTO extends BoardDTO{
	
	private List<BoardFileDTO> boardFileDTOs;

	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
}
