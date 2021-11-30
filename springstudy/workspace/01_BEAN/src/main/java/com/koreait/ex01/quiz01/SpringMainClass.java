package com.koreait.ex01.quiz01;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("quiz01.xml");
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("name : " + student.getName());
		System.out.println("age : " + student.getAge());
		System.out.println("scores : " + student.getExam().getScores().toString());
		System.out.println("average : " + student.getExam().getAverage());
		System.out.println("grade : " + student.getExam().getGrade());
		for (Map.Entry<String, String> entry : student.getHome().entrySet()) {
			System.out.println("home's " + entry.getKey() + " : " + entry.getValue());
		}
		
		ctx.close();
	}

}








