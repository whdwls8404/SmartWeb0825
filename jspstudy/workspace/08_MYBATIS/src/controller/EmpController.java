package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.EmpService;
import model.FindAllService;
import model.FindOneService;


@WebServlet("*.do")


public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmpController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();  /*  /MYBATIS/selectEmpList.do   */
		String[] arr = requestURI.split("/");         /*  {"", "MYBATIS", "selectEmpList.do"}   */
		
		EmpService empService = null;
		switch (arr[arr.length - 1]) {
		case "selectEmpList.do":
			empService = new FindAllService();
			break;
		case "selectEmp.do":
			empService = new FindOneService();
			break;
		}
		
		ModelAndView mav = null;
		if (empService != null) {
			mav = empService.execute(request, response);
		}
		
		// model에서 response로 직접 이동한 경우
		if (mav == null) {
			return;
		}
		
		// redirect 또는 forward 이동
		if (mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
