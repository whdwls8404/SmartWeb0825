package com.koreait.ex06.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping(value="selectBoardList")
	public String selectBoardList(Model model) {  // model : jsp로 값을 넘김
		logger.info("selectBoardList() 호출");  // console에 정보가 찍힘
		List<Board> list = service.selectBoardList();
		logger.info(list.toString());  // board 목록을 console에 찍어봄
		model.addAttribute("list", list);  // 내부적으로 request.setAttribute("list", list)임
		return "board/list";  // board/list.jsp로 forward함(model에 저장한 list가 전달됨)
	}
	
	@GetMapping(value="insertBoardForm")
	public String insertBoardForm() {
		return "board/insert";
	}
	
	@PostMapping(value="insertBoard")
	public void insertBoard(HttpServletRequest request, HttpServletResponse response) {
		service.insertBoard(request, response);
	}
	
	@GetMapping(value="selectBoardByNo")
	public String selectBoardByNo(@RequestParam(value="no") Long no, Model model) {
		model.addAttribute("board", service.selectBoardByNo(no));
		return "board/detail";
	}
	
	@GetMapping(value="updateBoardForm")
	public String updateBoardForm(@ModelAttribute(value="board") Board board) {
		// detail.jsp에서 보낸 파라미터 3개는 Board board가 받고,
		// model에 "board" 속성으로 저장함 : model.addAttribute("board", board")
		return "board/update";
	}
	
	@PostMapping(value="updateBoard")
	public void updateBoard(Board board, HttpServletResponse response) {
		service.updateBoard(board, response);
	}
	
	@GetMapping(value="deleteBoard")
	public void deleteBoard(@RequestParam(value="no", required=false, defaultValue="0") Long no,
						HttpServletResponse response) {
		service.deleteBoard(no, response);
	}
	
}
