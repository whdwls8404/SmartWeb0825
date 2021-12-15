package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import com.koreait.integration.domain.Book;

public interface BookService {
	public int addBook(Book book);
	public List<Book> findAllBook();
	public List<Book> findBook(Map<String, Object> map);
}
