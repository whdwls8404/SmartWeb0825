package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

	private Scanner sc;
	private List<Book> books;
	
	public Library() {
		sc = new Scanner(System.in);
		books = new ArrayList<Book>();
	}
	
	public void addBook() {
		System.out.println("=== 책 추가하기 ===");
		System.out.print("책 번호 >>> ");
		int bookNo = sc.nextInt();
		System.out.print("책 제목 >>> ");
		String title = sc.next();
		System.out.print("책 저자 >>> ");
		String author = sc.next();
		books.add(new Book(bookNo, title, author));
	}
	
	public void deleteBook() {
		System.out.println("=== 책 삭제하기 ===");
		System.out.print("삭제할 책 번호 >>> ");
		int bookNo = sc.nextInt();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getBookNo() == bookNo) {
				System.out.println(books.get(i).getTitle() + " 책이 삭제되었습니다.");
				books.remove(i);
				return;
			}
		}
		System.out.println(bookNo + "번 책은 존재하지 않습니다.");
	}
	
	public void printAllBook() {
		System.out.println("=== 전체 조회하기 ===");
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	public void menu() {
		System.out.println("**********");
		System.out.println("1. 책 추가");
		System.out.println("2. 책 삭제");
		System.out.println("3. 전체 조회");
		System.out.println("0. 종료");
		System.out.println("**********");
	}
	
	public void bookManage() {
		try {
			while (true) {
				menu();
				System.out.print("작업 선택(1, 2, 3, 0) >>> ");
				switch (sc.nextInt()) {
				case 1: addBook(); break;
				case 2: deleteBook(); break;
				case 3: printAllBook(); break;
				case 0: System.out.println("프로그램 종료"); return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
