package dto;

import java.sql.Date;

public class Comments {

	private Long cNo;
	private String writer;
	private String content;
	private Long bNo;
	private int state;
	private Date created;
	public Long getcNo() {
		return cNo;
	}
	public void setcNo(Long cNo) {
		this.cNo = cNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getbNo() {
		return bNo;
	}
	public void setbNo(Long bNo) {
		this.bNo = bNo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Comment [cNo=" + cNo + ", writer=" + writer + ", content=" + content + ", bNo=" + bNo + ", state="
				+ state + ", created=" + created + "]";
	}
	
}
