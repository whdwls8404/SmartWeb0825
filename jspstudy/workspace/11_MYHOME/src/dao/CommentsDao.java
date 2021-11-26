package dao;

import java.util.List;

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
	public List<Comments> selectCommentsList(Long bNo) {
		SqlSession ss = factory.openSession();
		List<Comments> list = ss.selectList("dao.comments.selectCommentsList", bNo);
		ss.close();
		return list;
	}
	
}
