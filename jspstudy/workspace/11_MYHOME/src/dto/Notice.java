package dto;

import java.sql.Date;

public class Notice {

	private Long   nNo;
	private String writer;
	private String title;
	private String content;
	private Long   hit;
	private String ip;
	private Date   nDate;
	private Date   nLastModified;
	
	public Long getnNo() {
		return nNo;
	}
	public void setnNo(Long nNo) {
		this.nNo = nNo;
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
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getnDate() {
		return nDate;
	}
	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}
	public Date getnLastModified() {
		return nLastModified;
	}
	public void setnLastModified(Date nLastModified) {
		this.nLastModified = nLastModified;
	}
	
}
