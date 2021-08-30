package ex3_abstract;

public class Company {

	private Staff[] staffs;
	private int idx;
	public Company(int staffCount) {
		staffs = new Staff[staffCount];
	}
	public void addStaff(Staff staff) {
		if (idx ==  staffs.length) {
			System.out.println("Full!");
			return;
		}
		staffs[idx++] = staff;
	}
	public void payInfo() {
		int total = 0;
		for (int i = 0; i < idx; i++) {
			total += staffs[i].pay();
		}
		System.out.println("전체직원급여: " + total + "원");
	}
	
}
