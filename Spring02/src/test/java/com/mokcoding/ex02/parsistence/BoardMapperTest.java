package com.mokcoding.ex02.parsistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex02.config.RootConfig;
import com.mokcoding.ex02.domain.BoardVO;
import com.mokcoding.ex02.persistence.BoardMapper;

import lombok.extern.log4j.Log4j;

// 테스트 할때 필요한것
@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit test 연결
@ContextConfiguration(classes = {RootConfig.class}) // 설정 파일 연결
@Log4j 
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void test() {
		testBoardInsert();
		testBoardList();
		testBoardByBoardId();
		testBoardUpdate();
		testBoarDelete();
	}
	
	private void testBoardList() {
		for(BoardVO boardVO : boardMapper.selectList()) {
			log.info(boardVO);
		}
	}

	private void testBoarDelete() {
		int result = boardMapper.delete(1);
		log.info(result + "행 삭제");
		
	}

	private void testBoardUpdate() {
		BoardVO boardVO = new BoardVO(1, "update", "update", null, null);
		int result = boardMapper.update(boardVO);
		log.info(result + "행 수정");
	}

	private void testBoardByBoardId() {
		BoardVO boardVO = boardMapper.selectOne(1);
		log.info(boardVO);
		
	}

	private void testBoardInsert() {
		BoardVO vo = new BoardVO(0, "test title", "test content", "guest", null);
		int result = boardMapper.insert(vo);
		log.info(result + "행 삽입");
	} 
	
}// end 
