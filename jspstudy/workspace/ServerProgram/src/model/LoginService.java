package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LoginService implements MemberService {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String name = request.getParameter("name");

		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setName(name);
		
		MemberDTO loginUser = MemberDAO.getInstance().selectMember(member);

		ModelAndView mav = null;
		if (loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
			mav = new ModelAndView("views/manager.jsp", true);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 이름을 확인하세요')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		return mav;
	}
}
