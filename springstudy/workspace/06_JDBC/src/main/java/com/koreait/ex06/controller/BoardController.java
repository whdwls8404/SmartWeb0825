package com.koreait.ex06.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.ex06.domain.Board;
import com.koreait.ex06.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	// 로그 생성기
	// System.out.println() 대체
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// BoardService Interface
	@Autowired
	private BoardService service;
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {  // model : jsp로 값을 넘김
		logger.info("selectBoardList() 호출");  // console에 정보가 찍힘
		List<Board> list = service.selectBoardList();
		logger.info(list.toString());  // board 목록을 console에 찍어봄
		model.addAttribute("list", list);  // board/list.jsp로 list로 저장함
		return "board/list";  // board/list.jsp로 forward함(model에 저장한 list가 전달됨)
	}
	
}





