package com.koreait.ex01.bean03;

import java.util.List;

public class ListBean {

	// field
	private List<String> list;

	// constructor
	// 디폴트 생성자 사용

	// getter/setter
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public void listInfo() {
		for (int i = 0, length = list.size(); i < length; i++) {
			System.out.println((i + 1) + "번째 요소: " + list.get(i));
		}
	}
	
}
