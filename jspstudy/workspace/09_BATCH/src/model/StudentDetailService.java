package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.StudentDao;
import dto.Student;

public class StudentDetailService implements StudentService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터 (sno 전달 없으면 "99999")
		String sno = request.getParameter("sno");
		if (sno == null) sno = "99999";
		
		// STUDENT 테이블에서 sno 학생 정보 가져오기
		Student student = StudentDao.getInstance().selectStudentBySno(sno);
		
		// request에 가져온 학생 정보 저장하기
		request.setAttribute("student", student);
		
		// views/studentDetail.jsp로 forward
		return new ModelAndView("views/studentDetail.jsp", false);
		
	}

}
