package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class FindBoardService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Optional<String> optIdx = Optional.ofNullable(request.getParameter("idx"));
		Long idx = Long.parseLong(optIdx.orElse("0"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		BoardDTO boardDTO = null;
		boardDTO = boardDAO.selectBoardByIdx(idx);
		
		if (boardDTO != null) {
			request.setAttribute("board", boardDTO);
			ModelAndView modelAndView = null;
			modelAndView = new ModelAndView("views/detail.jsp", false);
			return modelAndView;
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('게시글 정보를 찾을 수 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}
