package com.koreait.ex01.bean03;

import java.util.Set;

public class SetBean {

	// field
	private Set<String> set;

	// constructor
	// 디폴트 생성자
	
	// getter/setter
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public void setInfo() {
		// Set는 인덱스가 없다. (순서가 없는 자료형이기 때문에)
		for (String str : set) {
			if (str != null) {
				System.out.println(str);
			}
		}
	}

}
