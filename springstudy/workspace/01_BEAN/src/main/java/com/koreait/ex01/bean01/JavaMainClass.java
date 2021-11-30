package com.koreait.ex01.bean01;

public class JavaMainClass {

	public static void main(String[] args) {
		
		// EngineerCalculator 객체 생성 및 메소드 호출
		
		// 1. 디폴트 생성자 + setter
		EngineerCalculator calculator1 = new EngineerCalculator();
		calculator1.setA(7);
		calculator1.setB(2);
		calculator1.setCalculator(new Calculator());
		
		calculator1.add();
		calculator1.sub();
		calculator1.multiply();
		calculator1.div();
		calculator1.mod();
		
		// 2. 필드를 이용한 생성자
		EngineerCalculator calculator2 = new EngineerCalculator(12, 5, new Calculator());
		
		calculator2.add();
		calculator2.sub();
		calculator2.multiply();
		calculator2.div();
		calculator2.mod();

	}

}
