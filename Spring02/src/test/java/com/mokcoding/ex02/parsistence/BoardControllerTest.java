package com.mokcoding.ex02.parsistence;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mokcoding.ex02.config.ServletConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit test 연결
@ContextConfiguration(classes = {ServletConfig.class}) // 설정 파일 연결
@WebAppConfiguration
@Log4j 
public class BoardControllerTest {
	@Autowired
	private WebApplicationContext wac; // 웹 애플리케이션 객체
	
	// 스프링 MVC르 테스트 하는 mock-up 객체
	private MockMvc mock;
	
	@Before
	// JUnit 테스트를 실행하기 전에 초기화 작업으로 수행하는 메서드
	public void beforeTest() {
		log.info("beforeTest()");
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
		// 웹 애플리케이션 객체를 셋업하여 mock 객체 생성
	}
	
	@Test
	public void test() {
		testList();
//		testRegister();
	}

	private void testRegister() {
		log.info("testRegister()");
		
		RequestBuilder requestBuilder = post("/board/register")
				.param("boardTitle", "게시글 등록 입니다.")
				.param("boardContent", "게시글 테스트 중 입니다.")
				.param("memberId", "admin"); // request parameter 데이터 적용
		
		try {
			log.info(mock.perform(requestBuilder).andReturn());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testList() {
		log.info("testList()");
		
		RequestBuilder reqiestBuilder = get("/board/list");
		
		// get(String urlTemplate) : GET 요청에 대한 RequestBuilder생성.
		// post(String urlTemplate) : POST 요청에 대한 RequestBuilder생성.
		
		try {
			log.info(mock.perform(reqiestBuilder) // mock 객체 실행
					.andReturn() // request 실행 결과 리턴
					.getModelAndView()); // ModelAndView 객체 리턴
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
