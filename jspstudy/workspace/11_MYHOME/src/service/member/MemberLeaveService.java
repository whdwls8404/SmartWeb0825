package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberLeaveService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 탈퇴할 회원 정보 가져오기
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser");
		
		// 삭제
		// MemberDao.getInstance().deleteMemberLog(loginUser.getId());
		int result = MemberDao.getInstance().deleteMember(loginUser.getmNo());
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			// session 정보 제거
			session.invalidate();
			out.println("<script>");
			out.println("alert('회원탈퇴 성공')");
			out.println("location.href='index.jsp'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('회원탈퇴 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;
		
	}

}
