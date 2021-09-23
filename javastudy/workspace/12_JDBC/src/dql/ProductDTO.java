package dql;

import java.sql.Date;

// DTO
// 1. Data Transfer Object
// 2. 데이터 전송 객체
// 3. 자바  <------->  DB
//             DTO

public class ProductDTO {

	// PRODUCT 테이블의 칼럼과 ProductDTO의 필드를 1:1 매칭
	
	// field
	private long pNo;
	private String pName;
	private int price;
	private Date pDate;
	
	// method
	public long getpNo() {
		return pNo;
	}
	public void setpNo(long pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	@Override
	public String toString() {
		return "ProductDTO [pNo=" + pNo + ", pName=" + pName + ", price=" + price + ", pDate=" + pDate + "]";
	}
	
}
