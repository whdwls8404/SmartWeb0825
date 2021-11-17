package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.AddBoardService;
import model.BoardService;
import model.FindAllBoardService;
import model.FindBoardService;
import model.ModifyBoardService;
import model.RemoveBoardService;

@WebServlet("*.do")

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String[] arr = request.getRequestURI().split("/");
		String command = arr[arr.length - 1];
		
		ModelAndView modelAndView = null;
		
		BoardService boardService = null;
		switch (command) {
		case "insertBoard.do":
			boardService = new AddBoardService();
			break;
		case "deleteBoard.do":
			boardService = new RemoveBoardService();
			break;
		case "updateBoard.do":
			boardService = new ModifyBoardService();
			break;
		case "selectBoardOne.do":
			boardService = new FindBoardService();
			break;
		case "selectBoardList.do":
			boardService = new FindAllBoardService();
			break;
		case "insertBoardForm.do":
			modelAndView = new ModelAndView("views/insert.jsp", false);
			break;
		}
		
		if ( boardService != null ) {
			modelAndView = boardService.execute(request, response);
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
