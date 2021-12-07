package com.koreait.ex07.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex07.dao.BoardDAO;
import com.koreait.ex07.dto.Board;

@Controller
@RequestMapping("board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardDAO boardDAO;
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {
		List<Board> list = boardDAO.selectBoardList();
		logger.info(list.toString());
		model.addAttribute("list", list);
		return "board/list";
	}
	
}





