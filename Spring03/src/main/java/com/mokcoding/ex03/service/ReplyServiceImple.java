package com.mokcoding.ex03.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mokcoding.ex03.domain.ReplyVO;
import com.mokcoding.ex03.persistence.BoardMapper;
import com.mokcoding.ex03.persistence.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Service // service 코드 작성 할때 중요
@Log4j // 라이브러리 불려오는 코드
public class ReplyServiceImple implements ReplyService{

	@Autowired // 연결하는 기능을 갖는 코드 // 나중에 공부 어려움
	private ReplyMapper replyMapper; // java코드와 DB가 매핑 될수 있도록 하는 역할
	
	@Autowired
	private BoardMapper boardMapper; // 
	
   @Transactional(value = "transactionManager") // transactionManager가 관리
   @Override
   public int createReply(ReplyVO replyVO) { // 연산이 두개 이루어지는 상황을 트랜젝션 사용
      log.info("createReply()");
      int insertResult = replyMapper.insert(replyVO);
      log.info(insertResult + "행 댓글 추가");
      
      int updateresult = boardMapper.updateReplyCount(replyVO.getBoardId(), 1);
      log.info(updateresult + "행 게시판 수정");
      return 1;
   }

   @Override
   public List<ReplyVO> getAllReply(int boardId) {
      log.info("getAllReply()");
      return replyMapper.selectListByBoardId(boardId);
   }

   @Override
   public int updateReply(int replyId, String replyContent) {
      log.info("updateReply()");
      ReplyVO replyVO = new ReplyVO();
      replyVO.setReplyId(replyId);
      replyVO.setReplyContent(replyContent);
      return replyMapper.update(replyVO);
   }

   @Transactional(value = "transactionManager") // transactionManager가 관리
   @Override
   public int deleteReply(int replyId, int boardId) {
      log.info("deleteReply()");
      int deleteResult = replyMapper.delete(replyId);
      log.info(deleteResult + "행 삭제");
      int updateResult = boardMapper.updateReplyCount(boardId, -1);
      log.info(updateResult + "행 댓글 삭제");
      return replyMapper.delete(replyId);
   }

}