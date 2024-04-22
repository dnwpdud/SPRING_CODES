package com.mokcoding.ex02.parsistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex02.config.WebConfig;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleDriver;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit test 연결
@ContextConfiguration(classes = {WebConfig.class}) // 설정 파일 연결
@Log4j
public class OracleJDBCTest {
	private static final String URL =
			"jdbc:oracle:thin:@localhost:1521:xe"; // oracle 연결 url
	private static final String USER = "STUDY";  // 사용자 이름 
	private static final String PASSWORD = "1234"; // 비밀번호 
	
	@Test
	public void testConnection() {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			log.info("oracle 연결 성공 : conn = " + conn);
		} catch (SQLException e) {
			log.error("oracle 연결 실패 : " + e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}// end OracleJDBCTest
