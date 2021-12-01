package com.koreait.ex01.java.bean03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 여기에서 생성한 Bean을 app-context4.xml에서 불러 냅니다

@Configuration
public class BeanConfig {

	@Bean
	public Publisher publisher1() {
		return new Publisher("서울출판사", "02-111-1111");
	}
	
	@Bean
	public Book book1() {
		return new Book("JSP바로잡기", "김박사", publisher1());
	}
	
}
