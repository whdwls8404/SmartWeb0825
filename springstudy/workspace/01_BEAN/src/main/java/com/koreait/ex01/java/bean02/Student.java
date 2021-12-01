package com.koreait.ex01.java.bean02;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

	private Map<String, String> info;
	private List<Integer> scores;
	private Set<String> awards;
	
	public Map<String, String> getInfo() {
		return info;
	}
	public void setInfo(Map<String, String> info) {
		this.info = info;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public Set<String> getAwards() {
		return awards;
	}
	public void setAwards(Set<String> awards) {
		this.awards = awards;
	}
	
}
