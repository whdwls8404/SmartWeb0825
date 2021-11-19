package dto;

import java.sql.Date;

public class Board {

	private String bNo;
	private String writer;
	private String content;
	private Date bDate;
	
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
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
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	@Override
	public String toString() {
		return "Board [bNo=" + bNo + ", writer=" + writer + ", content=" + content + ", bDate=" + bDate + "]";
	}
	
}
