package com.mokcoding.ex02.service;

import java.util.List;

import com.mokcoding.ex02.domain.BoardVO;

public interface BoardService {
	int createBoard(BoardVO boardVO);
	List<BoardVO> getAllBoardVOs();
	BoardVO getBoardById(int boardId);
	int updateBoard(BoardVO boardVO);
	int deleteBoard(int boardId);
	
}
