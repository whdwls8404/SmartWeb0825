package com.koreait.ex13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex13.service.MemberService;
import com.koreait.ex13.service.MemberServiceImpl;

@Configuration
public class MemberConfig {

	@Bean
	public MemberService service() {
		return new MemberServiceImpl();
	}
	
}
