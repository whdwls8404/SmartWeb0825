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

import dto.BoardDTO;

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
	
	/* context.xml 내용으로 DataSource 객체 생성 */
	private static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
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
	public int insertBoard(BoardDTO boardDTO) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO board VALUES (board_seq.nextval, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, boardDTO.getTitle());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	// 3. 삭제
	public int deleteBoard(Long idx) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM board WHERE idx = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	// 4. 수정
	public int updateBoard(BoardDTO boardDTO) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE board SET title = ?, content = ? WHERE idx = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, boardDTO.getTitle());
			ps.setString(2, boardDTO.getContent());
			ps.setLong(3, boardDTO.getIdx());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	// 5. 개별 게시글 정보 반환
	public BoardDTO selectBoardByIdx(Long idx) {
		BoardDTO boardDTO = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT idx, title, writer, content, register FROM board WHERE idx = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setIdx(rs.getLong(1));
				boardDTO.setTitle(rs.getString(2));
				boardDTO.setWriter(rs.getString(3));
				boardDTO.setContent(rs.getString(4));
				boardDTO.setRegister(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return boardDTO;
	}

	// 6. 전체 게시글 목록 반환
	public List<BoardDTO> selectBoardList() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT idx, title, writer, content, register FROM board ORDER BY idx DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setIdx(rs.getLong(1));
				boardDTO.setTitle(rs.getString(2));
				boardDTO.setWriter(rs.getString(3));
				boardDTO.setContent(rs.getString(4));
				boardDTO.setRegister(rs.getString(5));
				boardList.add(boardDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return boardList;
	}
	
	// 7. 전체 게시글 개수 반환
	public int getBoardTotalCount() {
		int totalCount = 0;
		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(*) FROM board";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return totalCount;
	}
	
}
