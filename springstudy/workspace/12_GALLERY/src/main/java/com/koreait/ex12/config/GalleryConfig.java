package com.koreait.ex12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.koreait.ex12.service.GalleryService;
import com.koreait.ex12.service.GalleryServiceImpl;

@Configuration
public class GalleryConfig {

	@Bean
	public GalleryService service() {
		return new GalleryServiceImpl();
	}
	
	// 파일 첨부 시 등록해 둬야 할 Bean
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		multipartResolver.setMaxUploadSizePerFile(1024 * 1024 * 10);
		return multipartResolver;
	}
	
}