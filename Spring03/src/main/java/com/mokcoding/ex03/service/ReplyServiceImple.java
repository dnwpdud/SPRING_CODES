package com.mokcoding.ex03.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mokcoding.ex03.domain.ReplyVO;
import com.mokcoding.ex03.persistence.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Service // service 코드 작성 할때 중요
@Log4j // 라이브러리 불려오는 코드
public class ReplyServiceImple implements ReplyService{

	@Autowired // 연결하는 기능을 갖는 코드 // 나중에 공부 어려움
	private ReplyMapper replyMapper; // java코드와 DB가 매핑 될수 있도록 하는 역할
	
   @Override
   public int createReply(ReplyVO replyVO) {
      log.info("createReply()");
      return replyMapper.insert(replyVO);
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

   @Override
   public int deleteReply(int replyId) {
      log.info("deleteReply()");
      return replyMapper.delete(replyId);
   }

}