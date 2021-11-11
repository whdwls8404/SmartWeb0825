package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.StudentDeleteService;
import model.StudentDetailService;
import model.StudentInsertService;
import model.StudentListService;
import model.StudentService;
import model.StudentUpdateService;


@WebServlet("*.do")


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();                     /*   /BATCH/student/list.do   */    
		String contextPath = request.getContextPath();                   /*   /BATCH                   */
		String command = requestURI.substring(contextPath.length() + 1); /*   student/list.do          */
		
		ModelAndView mav = null;
		StudentService studentService = null;
		switch (command) {
		case "studentList.do":
			studentService = new StudentListService();
			break;
		case "insertForm.do":
			mav = new ModelAndView("views/studentInsert.jsp", false);
			break;
		case "insertStudent.do":
			studentService = new StudentInsertService();
			break;
		case "deleteStudent.do":
			studentService = new StudentDeleteService();
			break;
		case "studentDetail.do":
			studentService = new StudentDetailService();
			break;
		case "updateStudent.do":
			studentService = new StudentUpdateService();
			break;
		}
		
		if (studentService != null) {
			try {
				mav = studentService.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav != null) {
			if (mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
