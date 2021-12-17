package com.koreait.ex15.repository;

import org.springframework.stereotype.Repository;

import com.koreait.ex15.domain.Board;

@Repository
public interface BoardRepository {
	public int insertBoard(Board board);
}
