package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class RemoveBoardService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Optional<String> optIdx = Optional.ofNullable(request.getParameter("idx"));
		Long idx = Long.parseLong(optIdx.orElse("0"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.deleteBoard(idx);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('삭제 성공');");
			out.println("location.href='/QUIZ2/selectBoardList.do';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}
