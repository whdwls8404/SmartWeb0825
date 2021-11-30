package com.koreait.ex01.bean02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context2.xml");
		
		Car car1 = ctx.getBean("car1", Car.class);
		System.out.println("엔진타입: " + car1.getEngine().getType());
		System.out.println("배기량: " + car1.getEngine().getCc());
		System.out.println("마력: " + car1.getEngine().getHp());
		System.out.println("연비: " + car1.getEngine().getEfficiency());
		System.out.println("모델명: " + car1.getModel());
		
		Car car2 = ctx.getBean("car2", Car.class);
		System.out.println("엔진타입: " + car2.getEngine().getType());
		System.out.println("배기량: " + car2.getEngine().getCc());
		System.out.println("마력: " + car2.getEngine().getHp());
		System.out.println("연비: " + car2.getEngine().getEfficiency());
		System.out.println("모델명: " + car2.getModel());
		
		Car car3 = ctx.getBean("car3", Car.class);
		System.out.println("엔진타입: " + car3.getEngine().getType());
		System.out.println("배기량: " + car3.getEngine().getCc());
		System.out.println("마력: " + car3.getEngine().getHp());
		System.out.println("연비: " + car3.getEngine().getEfficiency());
		System.out.println("모델명: " + car3.getModel());
		
		ctx.close();
		
	}

}







