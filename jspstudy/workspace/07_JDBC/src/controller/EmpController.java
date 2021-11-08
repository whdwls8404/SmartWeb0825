package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.EmpAddService;
import model.EmpFindEmpListService;
import model.EmpFindEmpService;
import model.EmpModifyService;
import model.EmpRemoveService;
import model.EmpService;


@WebServlet("*.emp")


public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmpController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String[] arr = request.getRequestURI().split("/");
		String command = arr[arr.length - 1];
		
		ModelAndView modelAndView = null;
		
		EmpService empService = null;
		switch (command) {
		case "insert.emp":
			empService = new EmpAddService();
			break;
		case "delete.emp":
			empService = new EmpRemoveService();
			break;
		case "update.emp":
			empService = new EmpModifyService();
			break;
		case "selectDto.emp":
			empService = new EmpFindEmpService();
			break;
		case "selectList.emp":
			empService = new EmpFindEmpListService();
			break;
		case "insertForm.emp":
			modelAndView = new ModelAndView("views/insertEmp.jsp", false);
			break;
		}
		
		if ( empService != null ) {
			modelAndView = empService.execute(request, response);
		}
		
		if ( modelAndView == null ) {
			return;
		}
		
		if ( modelAndView.isRedirect() ) {
			response.sendRedirect( modelAndView.getView() );
		} else {
			request.getRequestDispatcher( modelAndView.getView() ).forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
