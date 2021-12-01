package com.koreait.ex03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex03.domain.Member;

@Configuration
public class MemberConfig {

	@Bean
	public Member member1() {
		Member member = new Member();
		member.setId("admin");
		member.setPw("1234");
		return member;
	}
	
	@Bean
	public Member member2() {
		return new Member("webmaster", "5678");
	}
	
}
