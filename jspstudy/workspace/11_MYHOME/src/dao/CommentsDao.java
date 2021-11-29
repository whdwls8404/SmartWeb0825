package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Comments;
import mybatis.config.DBService;

public class CommentsDao {

	private SqlSessionFactory factory;
	
	private static CommentsDao instance;
	private CommentsDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static CommentsDao getInstance() {
		if (instance == null) {
			instance = new CommentsDao();
		}
		return instance;
	}
	
	public int insertComments(Comments comment) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.comments.insertComments", comment);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	public int selectTotalCount(Long bNo) {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.comments.selectTotalCount", bNo);
		ss.close();
		return totalCount;
	}
	public List<Comments> selectCommentsList(Map<String, Long> map) {
		SqlSession ss = factory.openSession();
		List<Comments> list = ss.selectList("dao.comments.selectCommentsList", map);
		ss.close();
		return list;
	}
	public int deleteComments(Long cNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.comments.deleteComments", cNo);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
}
