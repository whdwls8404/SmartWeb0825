package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.comments.CommentsDeleteService;
import service.comments.CommentsInsertService;
import service.comments.CommentsListService;
import service.comments.CommentsService;

@WebServlet("*.comments")

public class CommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CommentsController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		CommentsService service = null;
		
		switch (command) {
		case "insert.comments":
			service = new CommentsInsertService();
			break;
		case "list.comments":
			service = new CommentsListService();
			break;
		case "delete.comments":
			service = new CommentsDeleteService();
			break;
		}
		
		if (service != null) {
			try {
				service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
