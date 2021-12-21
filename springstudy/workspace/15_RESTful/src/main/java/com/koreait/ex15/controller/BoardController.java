package com.koreait.ex15.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.ex15.service.BoardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;
	
	@PostMapping(value="api/boards", produces="application/json; charset=UTF-8")
	public Map<String, Object> addBoard(MultipartHttpServletRequest multipartRequest) {
		return boardService.addBoard(multipartRequest);
	}
	
}
