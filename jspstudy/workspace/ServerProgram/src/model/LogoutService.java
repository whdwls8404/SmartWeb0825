package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class LogoutService implements MemberService {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		return new ModelAndView("views/login.jsp", true);
	}
}
