package com.koreait.ex07.command;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex07.dao.BoardDAO;
import com.koreait.ex07.dto.Board;

public class BoardUpdateCommand {

	@Autowired
	private BoardDAO boardDAO;
	
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Long no = Long.parseLong(request.getParameter("no"));

		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setNo(no);
		
		int result = boardDAO.updateBoard(board);
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>");
				out.println("alert('갱신 성공')");
				out.println("location.href='/ex07/board/selectBoardByNo.do?no="+no+"'");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('갱신 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
