package com.mokcoding.ex03.config;

import javax.servlet.Filter;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	// root application context(Root WebApplicationContext)
	// 에 적용하는 설정 클래스 지정 메소드
	@Override
	protected Class<?>[] getRootConfigClasses() { //설정 관련된것을 불려온다.
		
		return new Class[] {RootConfig.class}; // RootConfig 클래스 리턴
	}
	
	// servlet application context(Servlet WebApplicationContext)
	// 에 적용하는 설정 클래스 지정 메소드
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ServletConfig.class}; // ServletConfig 클래스 리턴
	}
	
	// 
	@Override
	protected String[] getServletMappings() { // 기본적인 / 이고 HomeController.java 을 불려온다.

		return new String[] {"/"}; // 기본 경로 리턴
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return new Filter[] {encodingFilter};
	}

}// end WebConfig
