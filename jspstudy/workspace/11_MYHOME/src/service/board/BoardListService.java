package service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;
import dto.Board;

public class BoardListService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Board> list = BoardDao.getInstance().selectBoardList();
		
		request.setAttribute("list", list);
		
		return new ModelAndView("board/list.jsp", false);
		
	}

}
