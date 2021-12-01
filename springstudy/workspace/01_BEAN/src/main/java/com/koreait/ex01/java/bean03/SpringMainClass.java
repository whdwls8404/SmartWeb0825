package com.koreait.ex01.java.bean03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context4.xml");
		
		Book b1 = ctx.getBean("book1", Book.class);
		System.out.println(b1.getTitle());
		System.out.println(b1.getAuthor());
		System.out.println(b1.getPublisher().getName());
		System.out.println(b1.getPublisher().getTel());

		Book b2 = ctx.getBean("book2", Book.class);
		System.out.println(b2.getTitle());
		System.out.println(b2.getAuthor());
		System.out.println(b2.getPublisher().getName());
		System.out.println(b2.getPublisher().getTel());
		
		ctx.close();

	}

}
