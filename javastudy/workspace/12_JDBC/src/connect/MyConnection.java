package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyConnection {

	// new MyConnection() 없이 메소드 호출할 수 있도록
	// 클래스 메소드(static)로 처리한다.
	
	// Connection 인터페이스
	// 1. DB와의 접속 처리
	// 2. java.sql 패키지
	// 3. new Connection()는 불가
	// 4. Connection을 만드는 DriverManager 클래스를 통해서 생성
	
	
	// field
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";  // Oracle XE용
	private static String user = "SCOTT";
	private static String password = "TIGER";
	
	
	// method
	
	// 1. 접속 만들기
	public static Connection getConnection() throws Exception {
		
		// 1) ojdbc6.jar에 있는 OracleDriver 클래스 사용을 위해 메모리 로드
		//    OracleDriver 클래스 : 자바와 오라클 연결 담당
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2) Connection 생성과 반환
		return DriverManager.getConnection(url, user, password);
		
	}
	
	// 2. 접속 해제
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) con.close();
			if (ps != null) ps.close();
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
