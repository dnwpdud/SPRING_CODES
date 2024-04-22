package com.mokcoding.ex02.parsistence;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex02.config.RootConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit 실행 클래스 연결 
@ContextConfiguration(classes = {RootConfig.class}) // 설정 파일 연결
@Log4j
public class SqlSessionFactoryTest {
   
   @Autowired
   private SqlSessionFactory sqlSessionFactory;

   @Test
   public void testSessionFactory() {
      try (SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSessionFactory에서 SqlSession 객체 참조
         Connection conn = sqlSession.getConnection()) { // SqlSession 객체에서 Connection 객체 참조
         log.info("SqlSession 객체 : " + sqlSession);
         log.info("Connection 객체 : " + conn);
      } catch (Exception e) {
         log.error(e.getMessage());
      }
   }
} // end SqlSessionFactoryTest