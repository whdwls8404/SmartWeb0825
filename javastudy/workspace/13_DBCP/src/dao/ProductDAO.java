package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import connect.DBCPConnection;
import connect.DBCPDataSource;

// DAO
// 1. DataBase Access Object
// 2. 데이터베이스 접근 객체
// 3. INSERT, SELECT, UPDATE, DELETE 작업(CRUD) 담당

public class ProductDAO {
	
	// field
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private int resultCount;
	private String sql;

	private DataSource dataSource;
	
	// constructor
	public ProductDAO() {
		dataSource = DBCPDataSource.getDataSource();
	}
	
	// method (CRUD)
	public int insertProduct(String pName, int price) {
		try {
			// 1. DB접속 (Connection 대여)
			con = dataSource.getConnection();
			
			// 2. 쿼리문
			sql = "INSERT INTO PRODUCT(PNO, PNAME, PRICE, PDATE) " +
			      "VALUES(PRODUCT_SEQ.NEXTVAL, ?, ?, SYSDATE)";
			// 3. PreparedStatement ps 객체 생성
			ps = con.prepareStatement(sql);
			// 4. ?에 값(변수) 전달
			ps.setString(1, pName);
			ps.setInt(2, price);
			// 5. 쿼리문 실행
			resultCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Connection 반납
			// DBCPConnection.getInstance().close(con, ps, null);
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 결과 반환
		return resultCount;
	}
	
	public int deleteProduct(long pNo) {
		try {
			con = DBCPConnection.getInstance().getConnection();
			sql = "DELETE FROM PRODUCT WHERE PNO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, pNo);
			resultCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return resultCount;
	}
	
	public int updateProduct(long pNo, String pName, String strPrice, int choice) {
		if (choice == 3) {
			System.out.println("수정할 내용이 없습니다.");
			return 0;
		}
		try {
			con = DBCPConnection.getInstance().getConnection();
			switch (choice) {
			case 0:
				sql = "UPDATE PRODUCT SET PNAME = ?, PRICE = ? WHERE PNO = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, pName);
				ps.setInt(2, Integer.parseInt(strPrice));
				ps.setLong(3, pNo);
				break;
			case 1:
				sql = "UPDATE PRODUCT SET PRICE = ? WHERE PNO = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(strPrice));
				ps.setLong(2, pNo);
				break;
			case 2:
				sql = "UPDATE PRODUCT SET PNAME = ? WHERE PNO = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, pName);
				ps.setLong(2, pNo);
				break;
			}
			resultCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return resultCount;
	}
	
	
	
	
	
	
	
	
	
	
	
}
