package dql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.MyConnection;

public class DqlMainClass {

	public static void selectOne() {
		
		// 필요한 정보
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;  // select문의 실행 결과
		String sql = null;
		
		// 검색할 제품번호
		long searchNo = 1;
		
		try {
			
			// 1. DB접속
			con = MyConnection.getConnection();
			
			// 2. 쿼리문
			//    검색 결과가 1개가 될 수 있도록
			//    WHERE절에서 PK를 사용
			sql = "SELECT PNO, PNAME, PRICE, PDATE " +
			      "FROM PRODUCT " +
				  "WHERE PNO = ?";
			
			// 3. PreparedStatement ps 생성
			ps = con.prepareStatement(sql);
			
			// 4. ?에 값 전달하기
			ps.setLong(1, searchNo);
			
			// 5. 쿼리문 실행하기
			//    select문의 실행 결과는 ResultSet이다.
			//    ResultSet rs에는 검색 결과 행(row)이 모두 저장된다.
			//    rs에는 테이블의 칼럼 순서대로 값이 저장된다.
			//    실행 메소드 : executeQuery()
			rs = ps.executeQuery();
			
			// 6. 실행 결과
			//    1) 단일 행(single row)  : 분기문으로 결과의 존재 유무를 한 번만 점검
			//       if ( rs.next() ) { }
			//    2) 다중 행(multiple row): 반복문으로 결과의 존재 유무를 계속 점검
			//       while ( rs.next() ) { } 
			if (rs.next()) {
				
				// rs에는 테이블의 칼럼 순서대로 값이 저장된다.
				// PRODUCT 테이블의 칼럼 순서
				// PNO  PNAME  PRICE  PDATE
		
				// 1. 칼럼 번호를 이용하는 방식 (numbering)
				long pNo = rs.getLong(1);
				String pName = rs.getString(2);
				int price = rs.getInt(3);
				Date pDate = rs.getDate(4);
				System.out.println("제품번호: " + pNo);
				System.out.println("제품명: " + pName);
				System.out.println("제품가격: " + price);
				System.out.println("제조일자: " + pDate);
				
				// 2. 칼럼 이름을 이용하는 방식 (labeling)
				pNo = rs.getLong("PNO");
				pName = rs.getString("PNAME");
				price = rs.getInt("PRICE");
				pDate = rs.getDate("PDATE");
				System.out.println("제품번호: " + pNo);
				System.out.println("제품명: " + pName);
				System.out.println("제품가격: " + price);
				System.out.println("제조일자: " + pDate);
				
			} else {
				System.out.println("제품번호가 " + searchNo + "인 제품은 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(con, ps, rs);
		}
		
	}
	
	public static void selectValue() {
		
		// 현재 제품이 2개 있습니다.
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			con = MyConnection.getConnection();
			sql = "SELECT COUNT(*) FROM PRODUCT";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				
				// rs의 모습 (칼럼이 1개 있다.)
				// ------------
				// | COUNT(*) |
				// ------------
				// |     2    |
				// ------------
				
				// int rowCount = rs.getInt(1);  // 1번째 칼럼 정보 가져오기
				int rowCount = rs.getInt("COUNT(*)");  // "COUNT(*)" 칼럼 정보 가져오기
				
				if (rowCount > 0) {
					System.out.println("현재 제품이 " + rowCount + "개 있습니다.");
				} else if (rowCount == 0) {
					System.out.println("저장된 제품이 없습니다.");
				}
				
			} else {
				// PRODUCT 테이블이 존재하다면 else문이 동작하지 않는다.
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(con, ps, rs);
		}
		
	}
	
	public static void selectList() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			
			con = MyConnection.getConnection();
			sql = "SELECT PNO, PNAME, PRICE, PDATE FROM PRODUCT";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// ProductDTO 객체를 저장할 ArrayList 생성
			List<ProductDTO> products = new ArrayList<ProductDTO>();
			
			// 결과 집합(ResultSet)이 2개 이상인 경우
			// while문을 활용한다.
			while (rs.next()) {
				
				// 결과 행(row)은 하나씩 모두 ProductDTO 객체로 저장한다.
				ProductDTO product = new ProductDTO();
				product.setpNo( rs.getLong(1) );
				product.setpName( rs.getString(2) );
				product.setPrice( rs.getInt(3) );
				product.setpDate( rs.getDate(4) );
				
				// ProductDTO 객체를 ArrayList에 모은다.
				products.add(product);
				
			}
			
			// ArrayList 출력
			for (ProductDTO product : products) {
				System.out.println(product);  // ProductDTO 클래스의 toString() 메소드 동작
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(con, ps, rs);
		}
		
	}
	
	public static void main(String[] args) {
		selectList();
	}

}
