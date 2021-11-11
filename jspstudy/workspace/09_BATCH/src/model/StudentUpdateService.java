package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.StudentDao;
import dto.Student;

public class StudentUpdateService implements StudentService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		
		// 연산
		double ave = (kor + eng + mat) / 3.0;
		String grade = null;
		if (ave >= 90) {
			grade = "A";
		} else if (ave >= 80) {
			grade = "B";
		} else if (ave >= 70) {
			grade = "C";
		} else if (ave >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		// STUDENT 테이블로 보낼 Student 객체(DTO)
		Student student = new Student();
		student.setSno(sno);
		student.setName(name);
		student.setKor(kor);
		student.setEng(eng);
		student.setMat(mat);
		student.setAve(ave);
		student.setGrade(grade);
		
		// STUDENT 테이블에서 수정
		int result = StudentDao.getInstance().updateStudent(student);
		
		// 응답 처리
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('수정 성공')");
			out.println("location.href='/BATCH/studentDetail.do?sno=" + sno + "'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		// ModelAndView 없이 반환
		return null;
		
	}

}