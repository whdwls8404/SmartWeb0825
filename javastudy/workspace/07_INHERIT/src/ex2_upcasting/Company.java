package ex2_upcasting;

public class Company {

	private String name;
	private Staff[] staffs;
	private int idx;
	
	public Company(String name, int staffCount) {
		this.name = name;
		staffs = new Staff[staffCount];
	}
	
	public void addStaff(Staff staff) {
		if (idx == staffs.length) {
			System.out.println("Full!");
			return;
		}
		staffs[idx++] = staff;
	}
	public void companyInfo() {
		System.out.println("회사명: " + name);
		System.out.println("=====직원목록=====");
		for (int i = 0; i < idx; i++) {
			staffs[i].info();  // 호출 시 Staff의 info() 호출, 실행 시 실제 클래스의 info() 호출
		}
	}
	public void payInfo() {
		int total = 0;
		for (int i = 0; i < idx; i++) {
			total += staffs[i].pay();  // staffs[i]는 Staff 타입이므로 Staff의 메소드만 호출할 수 있다.
									   // Staff 클래스에 pay() 메소드를 만든다.
			/*
			 	== 또 다른 해결 ==
				SalaryMan은 SalaryMan으로 바꾸고, Alba는 Alba로 바꾼다.
				객체의 타입을 확인하기 위한 instanceof 연산자를 사용한다.
				if (staffs[i] instanceof SalaryMan) {
					total += ((SalaryMan)staffs[i]).pay();
				} else if (staffs[i] instanceof Alba) {
					total += ((Alba)staffs[i]).pay();
				}
			*/
		}
		System.out.println("전체 직원 급여: " + total + "원");
	}
	
}
