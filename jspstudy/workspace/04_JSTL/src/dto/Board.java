package dto;

public class Board {

	private String title;
	private String writer;
	private int view;
	
	public Board(String title, String writer, int view) {
		super();
		this.title = title;
		this.writer = writer;
		this.view = view;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
}
