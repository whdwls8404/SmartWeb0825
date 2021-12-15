package com.koreait.integration.domain;

public class Book {
	
	private Long no;
	private String title;
	private String preview;
	private String author;
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(Long no, String title, String preview, String author, int price) {
		super();
		this.no = no;
		this.title = title;
		this.preview = preview;
		this.author = author;
		this.price = price;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
