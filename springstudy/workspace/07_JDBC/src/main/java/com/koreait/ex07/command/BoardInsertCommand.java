package com.koreait.ex07.command;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex07.dao.BoardDAO;
import com.koreait.ex07.dto.Board;

public class BoardInsertCommand {

	@Autowired
	private BoardDAO boardDAO;
	
	public void execute(Model model) {
		
		// Model에서 request, response 꺼내기.
		// Model을 Map으로 변경하고 get() 메소드로 꺼낸다.
		
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		Board board = new Board();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		int result = boardDAO.insertBoard(board);
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>");
				out.println("alert('삽입 성공')");
				out.println("location.href='/ex07/board/selectBoardList.do'");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('삽입 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
