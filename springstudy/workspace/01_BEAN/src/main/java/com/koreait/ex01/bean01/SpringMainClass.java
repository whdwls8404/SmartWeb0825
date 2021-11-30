package com.koreait.ex01.bean01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
	
		// GenericXmlApplicationContext 클래스
		
		// 1. spring bean configuration file이 만든 <bean>을 생성하는 스프링 클래스
		// 2. AbstractApplicationContext 클래스의 자식 클래스
		
		String resourceLocations = "classpath:app-context1.xml";  // classpath: 생략 가능
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		// 스프링은 app-context1.xml 에 만들어 둔 <bean> 태그를 모두 bean으로 생성해서 가지고 있음.
		// getBean() 메소드를 이용해서 생성된 bean을 가져옴.
		
		// 제어의 역전
		// IoC : Inversion of Control
		// 기존에는 개발자가 new를 이용해서 직접 객체를 생성했지만,
		// 스프링은 스프링이 객체를 생성하고 개발자는 가져다 사용한다.
		
		EngineerCalculator e1 = ctx.getBean("eCalculator1", EngineerCalculator.class);
		e1.add();
		e1.sub();
		e1.multiply();
		e1.div();
		e1.mod();
		
		EngineerCalculator e2 = ctx.getBean("eCalculator2", EngineerCalculator.class);
		e2.add();
		e2.sub();
		e2.multiply();
		e2.div();
		e2.mod();
		
		EngineerCalculator e3 = ctx.getBean("eCalculator3", EngineerCalculator.class);
		e3.add();
		e3.sub();
		e3.multiply();
		e3.div();
		e3.mod();
		
		EngineerCalculator e4 = ctx.getBean("eCalculator4", EngineerCalculator.class);
		e4.add();
		e4.sub();
		e4.multiply();
		e4.div();
		e4.mod();
		
		ctx.close();

	}

}
