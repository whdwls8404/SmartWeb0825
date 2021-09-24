package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import connect.DBCPDataSource;
import dto.ProductDTO;

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
	
	// method (close)
	public void close() {
		try {
			if (con != null) con.close();  // Connection 반납
			if (ps != null) ps.close();
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			close();
		}
		// 결과 반환
		return resultCount;
	}
	
	public int deleteProduct(long pNo) {
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM PRODUCT WHERE PNO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, pNo);
			resultCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return resultCount;
	}
	
	public int updateProduct(long pNo, String pName, String strPrice, int choice) {
		if (choice == 3) {
			System.out.println("수정할 내용이 없습니다.");
			return 0;
		}
		try {
			con = dataSource.getConnection();
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
			close();
		}
		return resultCount;
	}
	
	public ProductDTO selectByPno(long pNo) {
		ProductDTO product = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT * FROM PRODUCT WHERE PNO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, pNo);
			rs = ps.executeQuery();
			if (rs.next()) {  // 조회 결과가 있으면
				product = new ProductDTO();  // product 생성
				product.setpNo( rs.getLong(1) );  // product.setpNo( rs.getLong("PNO") );
				product.setpName( rs.getString(2) );
				product.setPrice( rs.getInt(3) );
				product.setpDate( rs.getDate(4) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return product;
	}
	
	public List<ProductDTO> selectProductList() {
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT * FROM PRODUCT ORDER BY PNO";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setpNo( rs.getLong(1) );  // product.setpNo( rs.getLong("PNO") );
				product.setpName( rs.getString(2) );
				product.setPrice( rs.getInt(3) );
				product.setpDate( rs.getDate(4) );
				products.add(product);  // ArrayList에 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}
	
}
