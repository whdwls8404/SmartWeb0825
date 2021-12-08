package com.koreait.ex10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex10.repository.NoticeRepository;
import com.koreait.ex10.service.NoticeService;
import com.koreait.ex10.service.NoticeServiceImpl;

@Configuration
public class NoticeConfig {

	@Bean
	public NoticeRepository repository() {
		return new NoticeRepository();
	}
	
	@Bean
	public NoticeService service() {
		return new NoticeServiceImpl();
	}
	
}
