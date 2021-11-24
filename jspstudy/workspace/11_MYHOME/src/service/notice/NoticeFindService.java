package service.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.NoticeDao;
import dto.Notice;

public class NoticeFindService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터 처리
		String column = request.getParameter("column");
		String query = request.getParameter("query");
		
		// DB로 보낼 HashMap
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("query", "%" + query + "%");  // 만능문자 % 붙여서 전송
		
		// 검색 결과 가져오기
		List<Notice> list = NoticeDao.getInstance().findNotice(map);
		
		request.setAttribute("list", list);
		
		return new ModelAndView("notice/list.jsp", false);
		
	}

}
