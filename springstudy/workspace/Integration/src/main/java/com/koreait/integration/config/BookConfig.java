package com.koreait.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.integration.service.BookService;
import com.koreait.integration.service.BookServiceImpl;

@Configuration
public class BookConfig {

	@Bean
	public BookService service() {
		return new BookServiceImpl();
	}
	
}
