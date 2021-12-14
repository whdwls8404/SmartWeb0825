package com.koreait.ex14.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex14.service.EmployeeService;
import com.koreait.ex14.service.EmployeeServiceImpl;

@Configuration
public class EmployeeConfig {

	@Bean
	public EmployeeService service() {
		return new EmployeeServiceImpl();
	}

}
