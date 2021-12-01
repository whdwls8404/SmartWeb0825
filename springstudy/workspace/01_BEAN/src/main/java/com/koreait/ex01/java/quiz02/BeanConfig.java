package com.koreait.ex01.java.quiz02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("quiz04.xml")
public class BeanConfig {

	@Bean
	public Gun gun2() {
		return new Gun("K1", 20);
	}
	
	@Bean
	public Soldier soldier2() {
		Map<String, String> army = new HashMap<String, String>();
		army.put("name", "필승");
		army.put("address",  "강원도 고성군");
		return new Soldier("박중사", gun2(), army);
	}
	
}
