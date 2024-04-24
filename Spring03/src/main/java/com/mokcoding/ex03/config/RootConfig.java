package com.mokcoding.ex03.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// root-context.xml과 동일
@Configuration
@ComponentScan(basePackages = {"com.mokcoding.ex03.service"})
@ComponentScan(basePackages = {"com.mokcoding.ex03.aspect"}) // aop을 사용할 때 써음
@EnableAspectJAutoProxy // AutoProxy 사용을 위한 어노테이션
@MapperScan(basePackages = {"com.mokcoding.ex03.persistence"})// 페이지 경로로 Mapper 스캐닝
public class RootConfig {
	
	// 3번 // 인스턴스을 미리하고 쓰고 싶을 때 가져오는거?
	@Bean // 스프링 bean으로 설정. xml의 <bean>태그와 동일
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		//config.setDataSourceClassName("oracle.jdbc.OracleDriver"); // jdbc 드라이버 정보
		config.setDriverClassName("oracle.jdbc.OracleDriver"); // jdbc 드라이버 정보
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB 연결 url
		config.setUsername("STUDY"); // DB 사용자 아이디
		config.setPassword("1234");// DB 사용자 비밀번호
		
		config.setMaximumPoolSize(10);// 최대 풀(Pool)크기 설정
		config.setConnectionTimeout(30000); // Connection 타임 아웃 설정 (30초)
		HikariDataSource ds = new HikariDataSource(config); 
		// config 객체를 참조하여 DataSource 객체 생성
		
		return ds; // ds 객체 리턴
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean =
				new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
	}
	
	// 트랜잭션 매니저 객체를 빈으로 등록
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
} // end RootConfig
