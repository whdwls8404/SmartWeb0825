package com.koreait.ex01.bean01;

public class Calculator {

	// field
	
	// constructor
	public Calculator() {
		
	}
	
	// method
	public void add(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a + b));
	}
	public void sub(int a, int b) {
		System.out.println(a + "-" + b + "=" + (a - b));
	}
	public void multiply(int a, int b) {
		System.out.println(a + "*" + b + "=" + (a * b));
	}
	public void div(int a, int b) {
		System.out.println(a + "/" + b + "=" + (a / b));
	}
	public void mod(int a, int b) {
		System.out.println(a + "%" + b + "=" + (a % b));
	}
	
}
