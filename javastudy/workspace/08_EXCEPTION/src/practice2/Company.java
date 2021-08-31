package practice2;

import java.util.Scanner;

public class Company {

	private Scanner sc = new Scanner(System.in);
	private Staff[] staffs;
	private int idx;
	
	public void addStaff() {
		// 제가
		System.out.println("직원 추가");
	}
	public void deleteStaff() {
		// 각자
		System.out.println("직원 삭제");
	}
	public void printStaff() {
		// 각자
		System.out.println("직원 출력");
	}
	public void menu() {
		System.out.println("*****************");
		System.out.println("** 1. 직원등록 **");
		System.out.println("** 2. 직원삭제 **");
		System.out.println("** 3. 직원조회 **");
		System.out.println("** 0. 관리종료 **");
		System.out.println("*****************");
	}
	public void staffManage() {
		while (true) {
			menu();
			System.out.print("선택 >>> ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: addStaff(); break;  // switch문을 끝내는 break
			case 2: deleteStaff(); break;
			case 3: printStaff(); break;
			case 0: System.out.println("** 직원관리종료 **"); return;  // staffManage() 메소드를 종료하는 return
			}
		}
	}
	
}
