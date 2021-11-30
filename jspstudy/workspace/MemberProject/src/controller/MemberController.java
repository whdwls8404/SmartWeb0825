package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.DeleteMemberCommand;
import command.InsertMemberCommand;
import command.MemberService;
import command.SelectMemberListCommand;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		MemberService service =null;
		
		switch(command) {
		case "selectMemeberList.do":
			service = new SelectMemberListCommand();
			break;
		case "insertMember.do":
			service = new InsertMemberCommand();
			break;
		case "deleteMember.do":
			service = new DeleteMemberCommand();
			break;
		
		}
		
		if(service != null){
			service.execute(request, response);
		}		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
