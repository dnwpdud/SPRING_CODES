package com.mokcoding.ex03.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mokcoding.ex03.domain.ReplyVO;

@Mapper
public interface ReplyMapper {// ReplyMapper.xml 실제적으로 연결되는 DAO 인터페이스
   int insert(ReplyVO replyVO);
   List<ReplyVO> selectListByBoardId(int boardId);
   int update(ReplyVO replyVO);
   int delete(int replyId);
} // end ReplyMapper