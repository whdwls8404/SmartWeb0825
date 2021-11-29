package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Board;
import mybatis.config.DBService;

public class BoardDao {

	private SqlSessionFactory factory;
	
	private static BoardDao instance;
	private BoardDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	public int insertBoard(Board board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.board.insertBoard", board);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int selectTotalCount() {
		SqlSession ss = factory.openSession();
		int totalRecord = ss.selectOne("dao.board.selectTotalCount");
		ss.close();
		return totalRecord;
	}
	public List<Board> selectBoardList(Map<String, Integer> map) {
		SqlSession ss = factory.openSession();
		List<Board> list = ss.selectList("dao.board.selectBoardList", map);
		ss.close();
		return list;
	}
	public Board selectBoardView(Long bNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne("dao.board.selectBoardView", bNo);
		ss.close();
		return board;
	}
	public int deleteBoard(Long bNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.board.deleteBoard", bNo);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int updateBoard(Board board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.board.updateBoard", board);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
}
