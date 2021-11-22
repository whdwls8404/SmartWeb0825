package dto;

import java.sql.Date;

public class Free {

	private Long fNo;
	private String writer;
	private String content;
	private String ip;
	private Long hit;
	private Date created;
	private Date lastModified;
	private int state;
	private int depth;
	private Long groupNo;
	private int groupOrd;
	
	public Long getfNo() {
		return fNo;
	}
	public void setfNo(Long fNo) {
		this.fNo = fNo;
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
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public Long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	public int getGroupOrd() {
		return groupOrd;
	}
	public void setGroupOrd(int groupOrd) {
		this.groupOrd = groupOrd;
	}
	@Override
	public String toString() {
		return "Free [fNo=" + fNo + ", writer=" + writer + ", content=" + content + ", ip=" + ip + ", hit=" + hit
				+ ", created=" + created + ", lastModified=" + lastModified + ", state=" + state + ", depth=" + depth
				+ ", groupNo=" + groupNo + ", groupOrd=" + groupOrd + "]";
	}
	
}
