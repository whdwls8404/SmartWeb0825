package com.koreait.ex01.java.bean02;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Student student = ctx.getBean("s", Student.class);
		
		for (Map.Entry<String, String> entry : student.getInfo().entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println(student.getScores().toString());
		System.out.println(student.getAwards().toString());
		
		ctx.close();
		
	}
	
}
