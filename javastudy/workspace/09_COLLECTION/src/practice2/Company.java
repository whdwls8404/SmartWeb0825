package practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Command {
	EXIT, INSERT, DELETE, INQUIRY, INFO
}

public class Company {

	private String name;
	private List<Staff> staffs;
	private Scanner sc = new Scanner(System.in);
	
	public Company(String name) {
		this.name = name;
		staffs = new ArrayList<Staff>();
	}
	
	private void addStaff() {
		try {
			System.out.println("*** 사원 추가 ***");
			System.out.print("사원번호 입력 >>> ");
			long staffNo = sc.nextLong();
			System.out.print("사원명 입력 >>> ");
			String name = sc.next();
			System.out.print("부서명 입력 >>> ");
			String dept = sc.next();
			staffs.add( new Staff(staffNo, name, dept) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void deleteStaff() {
		try {
			System.out.println("*** 사원 삭제 ***");
			System.out.print("삭제할 사원번호 입력 >>> ");
			long staffNo = sc.nextLong();
			for (Staff staff : staffs) {
				if (staff.getStaffNo() == staffNo) {
					System.out.println(staff.getName() + " 사원이 삭제되었습니다.");
					staffs.remove(staff);
					return;
				}
			}
			System.out.println(staffNo + " 사원번호를 가진 사원이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void inquiryStaff() {
		try {
			System.out.println("*** 사원 조회 ***");
			System.out.print("조회할 사원번호 입력 >>> ");
			long staffNo = sc.nextLong();
			for (Staff staff : staffs) {
				if (staff.getStaffNo() == staffNo) {
					System.out.println(staff);
					return;
				}
			}
			System.out.println(staffNo + " 사원번호를 가진 사원이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void companyInfo() {
		System.out.println("회사명: " + name);
		System.out.println("*** 전체 사원 목록 ***");
		if (staffs.size() == 0) {
			System.out.println("현재 근무 중인 사원이 없습니다.");
			return;
		}
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}
	private void menu() {
		System.out.println("1. 사원 추가");
		System.out.println("2. 사원 삭제");
		System.out.println("3. 사원 조회");
		System.out.println("4. 회사 정보");
		System.out.println("0. 종료");
	}
	public void companyManage() {
		while (true) {
			menu();
			System.out.print("선택(1,2,3,4,0) >>> ");
			switch (sc.nextInt()) {
			case 1: addStaff(); break;
			case 2: deleteStaff(); break;
			case 3: inquiryStaff(); break;
			case 4: companyInfo(); break;
			case 0: System.out.println("*** 프로그램 종료 ***"); return;
			default: System.out.println("다시 선택하세요.");
			}
		}
	}
	
}
