package com.koreait.ex01.quiz01;

import java.util.Map;

public class Student {

    private String name;
    private int age;
    private Exam exam;
    private Map<String, String> home;  // address, tel

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Map<String, String> getHome() {
		return home;
	}
	public void setHome(Map<String, String> home) {
		this.home = home;
	}
    
}
