package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.JoinService;
import model.LeaveService;
import model.ListService;
import model.LoginService;
import model.LogoutService;
import model.MemberService;
import model.UpdateService;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		MemberService service = null;
		ModelAndView mav = null;
		
		switch (command) {
		case "list.do":
			service = new ListService();
			break;
		case "loginPage.do":
			request.getSession().invalidate();
			mav = new ModelAndView("views/login.jsp", true);
			break;
		case "login.do":
			service = new LoginService();
			break;
		case "logout.do":
			service = new LogoutService();
			break;
		case "joinPage.do":
			mav = new ModelAndView("views/join.jsp", true);
			break;
		case "join.do":
			service = new JoinService();
			break;
		case "update.do":
			service = new UpdateService();
			break;
		case "delete.do":
			service = new LeaveService();
			break;
		}
		
		if (service != null) {
			try {
				mav = service.execute(request, response);
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
