package com.koreait.ex17.domain;


// MySQL의 Datetime 타입과 호환되는 java.util.Date 사용
import java.util.Date;

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
	@Override
	public String toString() {
		return "Notice [no=" + no + ", title=" + title + ", content=" + content + ", created=" + created
				+ ", lastModified=" + lastModified + "]";
	}
	
}
