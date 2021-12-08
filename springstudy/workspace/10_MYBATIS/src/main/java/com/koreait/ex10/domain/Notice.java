package com.koreait.ex10.domain;

import java.sql.Date;

public class Notice {

	private Long no;
	private String title;
	private String content;
	private Date created;
	private Date lastModified;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	public Notice(Long no, String title, String content, Date created, Date lastModified) {
		super();
		this.no = no;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
