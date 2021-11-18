package dto;

import java.sql.Date;

public class Reply {

	private Long   rNo;
	private String writer;
	private String content;
	private String ip;
	private Long   nNo;
	private Date   rDate;
	
	public Long getrNo() {
		return rNo;
	}
	public void setrNo(Long rNo) {
		this.rNo = rNo;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Long getnNo() {
		return nNo;
	}
	public void setnNo(Long nNo) {
		this.nNo = nNo;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	
}
