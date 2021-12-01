package com.koreait.ex01.java.quiz01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
	
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Gugudan gugudan = ctx.getBean("gugudan", Gugudan.class);
		gugudan.printGugudan();
		
		ctx.close();

	}

}
