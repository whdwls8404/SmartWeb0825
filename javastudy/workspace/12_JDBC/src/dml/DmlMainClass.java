package dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.MyConnection;

public class DmlMainClass {

	// DML은 COMMIT/ROLLBACK을 사용할 수 있다.
	
	public static void insert1() {
		
		// 수동 커밋(COMMIT)
		
		// 필요한 변수
		Connection con = null;  // DB접속
		PreparedStatement ps = null;  // 쿼리문 실행
		int resultCount = 0;  // 쿼리문 실행 결과(INSERT, UPDATE, DELETE문은 int 타입의 결과 반환)
		String sql = null;  // 쿼리문
		
		// DB처리는 try-catch가 기본
		try {
			
			// 1. DB접속
			con = MyConnection.getConnection();
			
			// 2. 쿼리문작성
			// PreparedStatement : 미리 Statement(SQL)를 준비
			sql = "INSERT INTO PRODUCT(PNO, PNAME, PRICE, PDATE) VALUES " +
			      "(PRODUCT_SEQ.NEXTVAL, '홈런볼', 1500, '21/09/01')";
			
			// 3. PreparedStatement ps 생성
			ps = con.prepareStatement(sql);
			
			// 4. 수동 커밋 설정
			con.setAutoCommit(false);
			
			// 5. 쿼리문 실행
			//    1) 실행 메소드 : executeUpdate() - INSERT, UPDATE, DELETE문 모두 사용
			//    2) 반환 값 : 작업이 수행된 행(row)의 개수
			//       (1) 0 : 작업이 수행되지 않았다.
			//       (2) 1 : 작업이 수행된 행(row)이 1개이다. (작업이 수행되었다.)
			resultCount = ps.executeUpdate();
			
			if (resultCount > 0) {
				con.commit();  // 수동으로 커밋하기
				System.out.println("PRODUCT이 추가되었습니다.");
			} else {
				System.out.println("PRODUCT이 추가되지 않았습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			try {
				if (con != null) con.rollback();  // 예외 발생 시 rollback
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// N. DB접속해제
			MyConnection.close(con, ps, null);  // 모든 DML은 ResultSet을 사용하지 않는다.
		}
		
	}
	
	public static void main(String[] args) {
		insert1();
	}

}
