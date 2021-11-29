package service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import common.Page;
import dao.BoardDao;
import dto.Board;

public class BoardListService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터 page
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 전체 레코드 갯수
		int totalRecord = BoardDao.getInstance().selectTotalCount();
		
		// 페이징 처리 Page 객체 생성 및 데이터 계산
		Page p = new Page();
		p.setPageEntity(totalRecord, page);
		
		// beginRecord, endRecord를 DB로 보낼 Map
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRecord", p.getBeginRecord());
		map.put("endRecord", p.getEndRecord());
		
		// beginRecord ~ endRecord 사이 목록 가져오기
		List<Board> list = BoardDao.getInstance().selectBoardList(map);
		
		// board/list.jsp로 보낼 데이터
		request.setAttribute("list", list);
		request.setAttribute("pageEntity", p.getPageEntity("list.board"));
		request.setAttribute("startNum", totalRecord - (page - 1) * p.getRecordPerPage());
		
		return new ModelAndView("board/list.jsp", false);
		
	}

}