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
	
	// 5. 학생 삭제
	public int deleteStudent(String sno) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.student.deleteStudent", sno);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 6. 학생 정보 조회
	public Student selectStudentBySno(String sno) {
		SqlSession ss = factory.openSession();
		Student student = ss.selectOne("dao.student.selectStudentBySno", sno);
		ss.close();
		return student;
	}
	
	// 7. 학생 수정
	public int updateStudent(Student student) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.student.updateStudent", student);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 8. Top3 목록 반환
	public List<Student> selectTop3List() {
		SqlSession ss = factory.openSession();
		List<Student> top3List = ss.selectList("dao.student.selectTop3List");
		ss.close();
		return top3List;
	}
	
}