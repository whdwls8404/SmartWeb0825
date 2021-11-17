package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class ModifyBoardService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Long idx = Long.parseLong(request.getParameter("idx"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDTO boardDTO = new BoardDTO(idx, title, content);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.updateBoard(boardDTO);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('수정 성공');");
			out.println("location.href='/QUIZ2/selectBoardOne.do?idx=" + idx + "';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('수정 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}
