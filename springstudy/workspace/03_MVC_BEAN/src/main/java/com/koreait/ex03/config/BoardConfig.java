package com.koreait.ex03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex03.domain.Board;

@Configuration
public class BoardConfig {

	// class : Board
	// id    : board
	
	@Bean
	public Board board() {
		Board b = new Board();
		b.setTitle("공지사항");
		b.setContent("아주 급하다");
		return b;
	}
	
}
