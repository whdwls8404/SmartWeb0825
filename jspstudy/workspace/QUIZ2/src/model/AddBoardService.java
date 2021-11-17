package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class AddBoardService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDTO boardDTO = new BoardDTO(title, writer, content);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.insertBoard(boardDTO);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('삽입 성공');");
			out.println("location.href='/QUIZ2/selectBoardList.do'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삽입 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}
