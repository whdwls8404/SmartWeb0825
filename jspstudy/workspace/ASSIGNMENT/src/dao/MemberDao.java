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

import dto.Member;

public class MemberDao {
	private static MemberDao instance;
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	private static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) con.close();
			if (ps != null) ps.close();
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> selectList(){
		List<Member> list = new ArrayList<Member>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT NO, NAME, AGE, BIRTHDAY, REGDATE FROM MEMBER";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setNo(rs.getString(1));
				member.setName(rs.getString(2));
				member.setAge(rs.getInt(3));
				member.setBirthday(rs.getString(4));
				member.setRegDate(rs.getDate(5));
				list.add(member);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	public int insertMember(Member member)throws Exception {
		con = dataSource.getConnection();
		sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, SYSDATE)";
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getNo());
		ps.setString(2, member.getName());
		ps.setInt(3, member.getAge());
		ps.setString(4, member.getBirthday());
		int result = ps.executeUpdate();
		close(con, ps, null);
		return result;
	}
	
	public int delectMember(String no){
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM MEMBER WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	
}
