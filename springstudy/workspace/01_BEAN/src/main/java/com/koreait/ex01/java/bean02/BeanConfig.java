package com.koreait.ex01.java.bean02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public Student s() {  // <bean class="Student" id="s">
		
		Student student = new Student();
		
		Map<String, String> info = new HashMap<String, String>();
		info.put("name", "나학생");
		info.put("address", "서울시 영등포구 여의도동");
		info.put("tel", "010-1111-5555");
		student.setInfo(info);
		
		List<Integer> scores = Arrays.asList(50, 60, 70, 80, 90);
		student.setScores(scores);
		
		Set<String> awards = new HashSet<String>();
		awards.add("인기상");
		awards.add("개근상");
		student.setAwards(awards);
		
		return student;
		
	}
	
}
