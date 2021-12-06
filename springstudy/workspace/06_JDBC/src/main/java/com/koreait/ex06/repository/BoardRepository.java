package com.koreait.ex06.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.koreait.ex06.domain.Board;

public class BoardRepository {

	private DataSource dataSource;
	private static BoardRepository instance;
	private BoardRepository() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static BoardRepository getInstance() {
		if (instance == null) {
			instance = new BoardRepository();
		}
		return instance;
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
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
			con = dataSource.getConnection();
			sql = "SELECT NO, WRITER, TITLE, CONTENT, CREATED, LASTMODIFIED FROM BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Board board = new Board(rs.getLong(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
