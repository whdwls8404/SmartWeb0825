package service.free;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.FreeDao;
import dto.Free;

public class FreeListService implements FreeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 조회수 증가에서 사용된 session의 open 속성 제거하기
		HttpSession session = request.getSession();
		if (session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		
		int totalCount = FreeDao.getInstance().selectTotalCount();
		
		List<Free> list = FreeDao.getInstance().selectFreeList();
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		
		return new ModelAndView("free/list.jsp", false);
		
	}

}
