package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.DeleteMemberService;
import command.InsertMemberService;
import command.MemberService;
import command.SelectMemberListServcie;

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
		
		switch(command) {
		case "selectList.do" :
			service = new SelectMemberListServcie();
			break;
		case "insert.do" :
			service = new InsertMemberService();
			break;
		case "delete.do" :
			service = new DeleteMemberService();
			break;
		}
		
		if(service != null) {
			try {
				service.execute(request, response);				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
