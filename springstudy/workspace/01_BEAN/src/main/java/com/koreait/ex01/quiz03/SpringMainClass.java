package com.koreait.ex01.quiz03;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) throws Exception {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("quiz03.xml");
		
		OracleConnector connector = ctx.getBean("oracleConnector", OracleConnector.class);
		Connection con = connector.getConnection();
		if (con != null) con.close();
		
		ctx.close();

	}

}
