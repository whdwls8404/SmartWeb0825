package com.koreait.ex06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex06.repository.BoardRepository;
import com.koreait.ex06.service.BoardService;
import com.koreait.ex06.service.BoardServiceImpl;

/*
	@Bean으로 생성된 bean은 singleton이다.
*/

@Configuration
public class BoardConfig {

	@Bean
	public BoardRepository repository() {
		return new BoardRepository();
	}
	
	@Bean
	public BoardService service() {
		return new BoardServiceImpl();
	}
	
}
