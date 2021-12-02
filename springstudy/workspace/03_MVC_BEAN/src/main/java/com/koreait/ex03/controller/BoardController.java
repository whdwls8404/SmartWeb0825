package com.koreait.ex03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.ex03.domain.Board;

@Controller
public class BoardController {

	// ctx 없이 bean 생성하기
	
	// 1. @Inject, @Resource, @Autowired와 같은 애너테이션 중 하나를 사용
	// 2. @Autowired를 가장 많이 사용
	
	// @Autowired
	// 1. 객체 타입(class)이 일치하는 객체를 찾아서 알아서 생성
	// 2. 필드, 생성자, setter를 대상으로 함
	// 3. 필드는 필드 자체에 생성, 생성자나 setter는 매개변수에 생성
	
	/*
		1. 필드에 @Autowired 지정하기
		   필드마다 붙여야 함. 필드가 10개이면 10개의 @Autowired가 필요함. 자주 안 씀.
		@Autowired
		private Board myBoard;  // 반환타입이 Board인 bean을 찾아서 가져와서 myBoard에 주입	
	*/
	
	/*
		2. 생성자에 @Autowired 지정하기
		   생성자에는 @Autowired를 생략해도 된다.
		
		private Board myBoard;
		
		@Autowired  // 생략할 수 있다.
		public BoardController(Board myBoard) {  // 생성자를 만들면, 매개변수로 자동 주입된다.
			super();
			this.myBoard = myBoard;
		}
	*/
	
	/*
		3. setter에 @Autowired 지정하기
		   @Autowired를 꼭 적어야 한다.
		   setter 메소드명을 마음대로 작성해도 된다.
		
		private Board myBoard;
		
		@Autowired  // 생략할 수 없다. 꼭 적어야 한다.
		public void setBoard(Board myBoard) {  // 매개변수로 자동 주입된다.
			this.myBoard = myBoard;
		}
	*/

	
	@Autowired
	private Board myBoard;
	
	@GetMapping("boardView.do")
	public String a(Model model) {
		model.addAttribute("board", myBoard);
		return "board/boardDetail";
	}
	
}
