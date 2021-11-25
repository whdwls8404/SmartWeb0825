package dto;

import java.sql.Date;

public class Board {

	private Long bNo;
	private String writer;
	private String title;
	private String content;
	private String fileName;
	private String saveName;
	private Date created;
	private Date lastModified;
	
	public Long getbNo() {
		return bNo;
	}
	public void setbNo(Long bNo) {
		this.bNo = bNo;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
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
		return "Board [bNo=" + bNo + ", writer=" + writer + ", title=" + title + ", content=" + content + ", fileName="
				+ fileName + ", saveName=" + saveName + ", created=" + created + ", lastModified=" + lastModified + "]";
	}
	
}
