package com.koreait.ex07.command;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex07.dao.BoardDAO;

public class BoardDeleteCommand {

	@Autowired
	private BoardDAO boardDAO;
	
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		Long no = Long.parseLong(request.getParameter("no"));

		int result = boardDAO.deleteBoard(no);
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>");
				out.println("alert('삭제 성공')");
				out.println("location.href='/ex07/board/selectBoardList.do'");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('삭제 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
