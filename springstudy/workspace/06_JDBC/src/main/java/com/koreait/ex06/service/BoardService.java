package com.koreait.ex06.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.ex06.domain.Board;

public interface BoardService {
	public List<Board> selectBoardList();
	public void insertBoard(HttpServletRequest request, HttpServletResponse response);
	public Board selectBoardByNo(Long no);
}






