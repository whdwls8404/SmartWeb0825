package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;

public class FindAllBoardService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		
		request.setAttribute("boardTotalCount", boardDAO.getBoardTotalCount());
		request.setAttribute("boardList", boardDAO.selectBoardList());
		
		return new ModelAndView("views/list.jsp", false);
		
	}

}
