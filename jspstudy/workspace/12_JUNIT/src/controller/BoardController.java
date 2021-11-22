package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.mybatis.BoardDeleteService;
import service.mybatis.BoardInsertService;
import service.mybatis.BoardListService;
import service.mybatis.BoardService;

@WebServlet("*.do")

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		BoardService service = null;
		
		switch (command) {
		case "selectBoardList.do":
			service = new BoardListService();
			break;
		case "insertBoard.do":
			service = new BoardInsertService();
			break;
		case "deleteBoard.do":
			service = new BoardDeleteService();
			break;
		}
		
		if (service != null) {
			service.execute(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
