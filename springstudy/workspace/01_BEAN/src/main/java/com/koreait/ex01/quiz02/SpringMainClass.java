package com.koreait.ex01.quiz02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("quiz02.xml");

		Member m = ctx.getBean("member", Member.class);
		m.memberInfo();
		
		ctx.close();
		
	}

}
