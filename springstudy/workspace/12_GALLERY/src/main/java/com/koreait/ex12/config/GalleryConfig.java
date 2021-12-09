package com.koreait.ex12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex12.service.GalleryService;
import com.koreait.ex12.service.GalleryServiceImpl;

@Configuration
public class GalleryConfig {

	@Bean
	public GalleryService service() {
		return new GalleryServiceImpl();
	}
	
}