package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;

public class ListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("list", MemberDAO.getInstance().selectAllMember());
		return new ModelAndView("views/list.jsp", false);
	}

}
