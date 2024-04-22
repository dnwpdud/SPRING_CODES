package com.mokcoding.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mokcoding.ex02.domain.BoardVO;
import com.mokcoding.ex02.persistence.BoardMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImple implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int createBoard(BoardVO boardVO) {
		log.info("createBoard()");
		int result = boardMapper.insert(boardVO);
		return result;
	}

	@Override
	public List<BoardVO> getAllBoardVOs() {
		log.info("getAllBoards()");
		return boardMapper.selectList();
	}

	@Override
	public BoardVO getBoardById(int boardId) {
		log.info("getBoardById()");
		return boardMapper.selectOne(boardId);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		log.info("updateBoard()");
		return boardMapper.update(boardVO);
	}

	@Override
	public int deleteBoard(int boardId) {
		log.info("deleteBoard()");
		return boardMapper.delete(boardId);
	}
	
}
