package com.koreait.ex04.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.ex04.domain.Board;

@Controller
@RequestMapping("board")  // board로 시작하는 mapping을 처리하는 컨트롤러이다
public class BoardController {

	@GetMapping("v1.do")  // 실제로는 board/v1.do를 의미함
	public String v1() {
		return "board/boardDetail";
	}
	
	/*
		ModelAndView 클래스
		
		1. 스프링 초기에 많이 사용한 클래스(스프링 2 이전)
		2. 앞으로는 사용을 자제 (Model을 대신 사용)
		3. Model과 View를 동시에 처리
		   (어디로 어떤 값을 보내겠다)
	*/
	@GetMapping("v2.do")
	public ModelAndView v2() {
		
		ModelAndView mav = new ModelAndView();
		
		// View 설정
		mav.setViewName("board/boardDetail");
		
		// Model 설정 (넘겨줄 값)
		mav.addObject("board", new Board.BoardBuilder(1L, "긴급공지", "내일 청소")
				.setHit(0L)
				.build());
		
		return mav;
		
	}
	
	
	/*  아래 보기 중 사용할 수 없는 파라미터 처리 방식은?
			1. HttpServletRequest
			2. @RequestParam
			3. Board board
			정답 : 3 (Board 클래스에 setter가 없다.)
	 */
	
	
	//  <a href="board/v3.do?no=10&title=공지&content=내용">
	@GetMapping("v3.do")
	public ModelAndView v3(@RequestParam(value="no") Long no,
			@RequestParam(value="title") String title,
			@RequestParam(value="content") String content) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardDetail");
		mav.addObject("board", new Board.BoardBuilder(no, title, content)
									.build());
		return mav;
		
	}
	
}
