package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.EmpDTO;

public class EmpDAO {
	
	/* single */
	private static EmpDAO empDAO;
	private EmpDAO() {
		
	}
	public static EmpDAO getInstance() {
		if (empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}
	
	/* context.xml 내용으로 DataSource 객체 생성 */
	private static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
			// WAS가 톰캣인 경우   java:comp/env
			// <Resource name>     jdbc/oracle11g
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/* field */
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	/* method */
	
	// 1. 접속 해제
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) { con.close(); }
			if (ps != null) { ps.close(); }
			if (rs != null) { rs.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2. 삽입
	public int insertEmp(EmpDTO empDTO) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO emp VALUES (emp_seq.nextval, ?, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, empDTO.getName());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	// 3. 삭제
	public int deleteEmp(Long num) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM emp WHERE num = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, num);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	// 4. 수정
	public int updateEmp(EmpDTO empDTO) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE emp SET name = ?, hire = ? WHERE num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, empDTO.getName());
			ps.setDate(2, empDTO.getHire());
			ps.setLong(3, empDTO.getNum());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	// 5. 개별 사원 정보 반환
	public EmpDTO selectEmpDTO(Long num) {
		EmpDTO empDTO = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT num, name, hire FROM emp WHERE num = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setNum( num );  // rs.getLong("num"), rs.getLong(1)
				empDTO.setName( rs.getString("name") );  // rs.getString(2)
				empDTO.setHire( rs.getDate("hire") );    // rs.getDate(3)
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return empDTO;
	}

	// 6. 전체 사원 목록 반환
	public List<EmpDTO> selectEmpList() {
		List<EmpDTO> empList = new ArrayList<EmpDTO>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT num, name, hire FROM emp ORDER BY num DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EmpDTO empDTO = new EmpDTO();
				empDTO.setNum( rs.getLong("num") );      // rs.getLong(1)
				empDTO.setName( rs.getString("name") );  // rs.getString(2)
				empDTO.setHire( rs.getDate("hire") );    // rs.getDate(3)
				empList.add(empDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return empList;
	}
	
}
