package com.koreait.ex11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex11.service.NoticeService;
import com.koreait.ex11.service.NoticeServiceImpl;

@Configuration
public class NoticeConfig {

	@Bean
	public NoticeService service() {
		return new NoticeServiceImpl();
	}
	
}
