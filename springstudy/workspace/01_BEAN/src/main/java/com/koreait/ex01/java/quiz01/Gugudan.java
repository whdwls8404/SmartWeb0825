package com.koreait.ex01.java.quiz01;

public class Gugudan {

    private int begin;
    private int end;
    private Calculator calculator;
    
    public Gugudan() {
		
	}
	public Gugudan(int begin, int end, Calculator calculator) {
		super();
		this.begin = begin;
		this.end = end;
		this.calculator = calculator;
	}

	public void printGugudan() {
		for (int dan = begin; dan <= end; dan++) {
			for (int n = 1; n <= 9; n++) {
				System.out.println(dan + "x" + n + "=" + calculator.mul(dan, n));
			}
		}
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
    
}
