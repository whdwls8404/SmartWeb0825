package com.koreait.ex07.dto;

public class Board {

	private Long no;
	private String writer;
	private String title;
	private String content;
	private String created;
	private String lastModified;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	public Board(Long no, String writer, String title, String content, String created, String lastModified) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.created = created;
		this.lastModified = lastModified;
	}

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	@Override
	public String toString() {
		return "Board [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content + ", created="
				+ created + ", lastModified=" + lastModified + "]";
	}
	
}
