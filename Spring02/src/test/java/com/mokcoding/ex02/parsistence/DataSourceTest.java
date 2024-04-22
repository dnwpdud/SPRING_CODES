package com.mokcoding.ex02.parsistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex02.config.RootConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit test 연결
@ContextConfiguration(classes = {RootConfig.class}) // 설정 파일 연결
@Log4j 
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource; // RootConfig.java에 dataSource메소드을 불려온다.
	
	@Test
	public void testConnection() {
		try (Connection conn = dataSource.getConnection()){// try-catch 리소스 해제
			// 위
			log.info("Connection 객체 : " + conn);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
} // end DataSourceTest
