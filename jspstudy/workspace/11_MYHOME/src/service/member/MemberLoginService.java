package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberLoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		// ID/PW가 일치하는 회원 조회
		Member loginUser = MemberDao.getInstance().selectMember(member);
		
		// ID/PW가 일치하는 회원이 있으면
		if (loginUser != null) {
			
			// 회원 정보를 session에 loginUser로 저장함.
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			// 로그인 기록 남기기.
			MemberDao.getInstance().loginLog(id);
			
			// index.jsp로 redirect 이동.
			return new ModelAndView("index.jsp", true);
			
		}
		// ID/PW가 일치하는 회원이 없으면
		else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('일치하는 회원 없음')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}