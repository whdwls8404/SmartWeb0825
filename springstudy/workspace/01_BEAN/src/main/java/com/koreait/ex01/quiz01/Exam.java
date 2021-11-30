package com.koreait.ex01.quiz01;

import java.util.List;

public class Exam {

    private List<Integer> scores;  // 5개의 점수
    private double average;        // 평균
    private char grade;            // A ~ F

    public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {  /* <property name="scores"> 태그에 의해서 호출됨. */
		this.scores = scores;
		setAverage();  /* 추가한 메소드 실행 */
		setGrade();    /* 추가한 메소드 실행 */
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public void setAverage() {  /* 추가 */
		int total = 0;
		int length = scores.size();
		for (int i = 0; i < length; i++) {
			total += scores.get(i);
		}
		this.average = (double)total / length;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public void setGrade() {  /* 추가 */
		if (average >= 90) grade = 'A';
		else if (average >= 80) grade = 'B';
		else if (average >= 70) grade = 'C';
		else if (average >= 60) grade = 'D';
		else grade = 'F';
	}
    
}
