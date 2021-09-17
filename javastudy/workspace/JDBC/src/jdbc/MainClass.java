package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			String sql = "CREATE TABLE SAMPLE (NO NUMBER)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
			
			System.out.println("sample 테이블 작성 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
