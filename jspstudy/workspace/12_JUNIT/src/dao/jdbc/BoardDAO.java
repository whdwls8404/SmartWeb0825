package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Board;

public class BoardDAO {

	/* singleton */
	private static BoardDAO instance;
	private BoardDAO() {
		
	}
	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	/* field */
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	/* method */
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "1111";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	private void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) con.close();
			if (ps != null) ps.close();
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Board> selectBoardList() {
		List<Board> list = new ArrayList<Board>();
		try {
			con = getConnection();
			sql = "SELECT BNO, WRITER, CONTENT, BDATE FROM BOARD ORDER BY BNO";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setbNo(rs.getString(1));
				board.setWriter(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setbDate(rs.getDate(4));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	public int insertBoard(Board board) throws Exception {
		int result = 0;
		con = getConnection();
		sql = "INSERT INTO BOARD VALUES (?, ?, ?, SYSDATE)";
		ps = con.prepareStatement(sql);
		ps.setString(1, board.getbNo());
		ps.setString(2, board.getWriter());
		ps.setString(3, board.getContent());
		result = ps.executeUpdate();
		close(con, ps, null);
		return result;
	}
	public int deleteBoard(String bNo) {
		int result = 0;
		try {
			con = getConnection();
			sql = "DELETE FROM BOARD WHERE BNO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, bNo);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	public Board selectBoardBybNo(String bNo) {
		Board board = null;
		try {
			con = getConnection();
			sql = "SELECT BNO, WRITER, CONTENT, BDATE FROM BOARD WHERE BNO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, bNo);
			rs = ps.executeQuery();
			if (rs.next()) {
				board = new Board();
				board.setbNo(rs.getString(1));
				board.setWriter(rs.getString(2));
				board.setContent(rs.getString(3));
				board.setbDate(rs.getDate(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return board;
	}
	
}
