package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.StudentDao;
import dto.Student;

public class StudentListService implements StudentService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// DB 접근을 위한 StudentDao
		StudentDao dao = StudentDao.getInstance();
		
		// 학생 목록 가져오기
		List<Student> list = dao.selectAllStudent();
		
		// 전체 학생 수 가져오기
		int totalCount = dao.getTotalCount();
		
		// 전체 학생 평균 가져오기
		double average = dao.getAverage();
		
		// request에 목록, 전체 학생 수, 전체 학생 평균 저장하기
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("average", average);
		
		// 이동 : views/studentList.jsp로 forward
		return new ModelAndView("views/studentList.jsp", false);
		
	}

}
