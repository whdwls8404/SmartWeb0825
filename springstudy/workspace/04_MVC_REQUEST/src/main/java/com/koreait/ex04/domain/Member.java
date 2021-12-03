package com.koreait.ex04.domain;

public class Member {

	private Long idx;
	private String id;
	private String name;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(Long idx, String id, String name) {
		super();
		this.idx = idx;
		this.id = id;
		this.name = name;
	}
	
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
