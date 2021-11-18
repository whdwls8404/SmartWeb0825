package dto;

import java.sql.Date;

public class Member {
	
	private Long mNo;
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date mDate;
	
	public Long getmNo() {
		return mNo;
	}
	public void setmNo(Long mNo) {
		this.mNo = mNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	
}
