package com.koreait.ex07.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.ex07.dao.BoardDAO;
import com.koreait.ex07.dto.Board;

public class BoardViewCommand {

	@Autowired
	private BoardDAO boardDAO;
	
	public void execute(Model model) {
	
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		Long no = Long.parseLong(request.getParameter("no"));
		
		Board board = boardDAO.selectBoardByNo(no);
		
		model.addAttribute("board", board);
		
	}
	
}
