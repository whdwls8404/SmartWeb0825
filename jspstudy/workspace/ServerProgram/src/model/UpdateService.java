package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateService implements MemberService {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		MemberDTO loginUser = (MemberDTO)request.getSession().getAttribute("loginUser");
		
		MemberDTO member = new MemberDTO();
		member.setNo(loginUser.getNo());
		member.setName(name);
		member.setPoint(point);
		
		String grade = null;
		if (point < 3000) {
			grade = "bronze";
		} else if (point < 4000) {
			grade = "silver";
		} else if (point < 5000) {
			grade = "gold";
		} else {
			grade = "vip";
		}
		member.setGrade(grade);
		
		int result = MemberDAO.getInstance().updateMember(member);
		
		if (result > 0) {
			loginUser.setName(name);
			loginUser.setPoint(point);
			loginUser.setGrade(grade);
		}
		
		return new ModelAndView("views/manager.jsp", true);
		
	}
}
