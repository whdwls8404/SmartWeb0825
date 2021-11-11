package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Student;
import mybatis.config.DBService;

public class StudentDao {

	/* StudentDao의 모든 메소드는 factory에서 SqlSession을 얻어 낸다. */
	private SqlSessionFactory factory;
	
	private static StudentDao instance;
	private StudentDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static StudentDao getInstance() {
		if (instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}
	
	// 1. 학생 목록
	public List<Student> selectAllStudent() {
		SqlSession ss = factory.openSession();
		List<Student> list = ss.selectList("dao.student.selectAllStudent");  // mapper's namespace + id
		ss.close();
		return list;
	}
	
	// 2. 전체 학생 수
	public int getTotalCount() {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.student.getTotalCount");
		ss.close();
		return totalCount;
	}
	
	// 3. 전체 학생 평균
	public double getAverage() {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne("dao.student.getAverage");
		ss.close();
		return average;
	}
	
	// 4. 학생 등록
	public int insertStudent(Student student) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.student.insertStudent", student);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
	
	
	
	
}
