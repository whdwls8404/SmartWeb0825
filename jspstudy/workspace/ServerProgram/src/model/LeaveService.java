package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LeaveService implements MemberService {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Long no = ((MemberDTO)request.getSession().getAttribute("loginUser")).getNo();
		
		int result = MemberDAO.getInstance().deleteMember(no);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			request.getSession().invalidate();
			out.println("<h1>탈퇴되었습니다.</h1>");
			out.println("<a href=\"joinPage.do\">회원가입</a>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('탈퇴되지 않았습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}
}
