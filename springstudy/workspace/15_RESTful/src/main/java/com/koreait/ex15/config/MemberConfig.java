package com.koreait.ex15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex15.service.MemberService;
import com.koreait.ex15.service.MemberServiceImpl;

@Configuration
public class MemberConfig {

	@Bean
	public MemberService service() {
		return new MemberServiceImpl();
	}
	
}
